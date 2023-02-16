
package com.mycompany.hazelcastdemo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Lucifer
 */
public class HazelcastDemo {

    public static void main(String[] args) throws SQLException {
    HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
    IMap<Integer, Integer> map = hazelcastInstance.getMap("myMap");
    Random rand = new Random();
    int numberOfEntries = 20000;
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < numberOfEntries; i++) {
      map.put(i, rand.nextInt());
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Time to put " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");
    startTime = System.currentTimeMillis();
    for (int i = 0; i < numberOfEntries; i++) {
      int key = rand.nextInt(numberOfEntries);
      int value = map.get(key);
    }
    endTime = System.currentTimeMillis();
    System.out.println("Time to get " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");    
    String url="jdbc:oracle:thin:@//localhost:1521/XE";
    String user="system";
    String password="oracle";
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("Load success");
        Connection con= DriverManager.getConnection(url,user,password);
        System.out.println("Baglanti basarili"+con);
        rand = new Random();
        numberOfEntries = 50000;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfEntries; i++) {
            String query="insert into DB2 (SAYİ) values ('"+rand.nextInt(2000)+"') ";
            Statement stmt=con.createStatement();
            stmt.execute(query);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time to put " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");

            List<String> list=new ArrayList<>();
            startTime = System.currentTimeMillis();
            Statement stmt=con.createStatement();
            ResultSet rs;
            rs=stmt.executeQuery("Select * from DB2");
            int sayac=0;
            while (rs.next()) {
                String sayi = rs.getString("SAYİ");
                list.add(sayi);
                sayac++;
            }
            endTime = System.currentTimeMillis();

            System.out.println("Time to get " + sayac + " entries: " + (endTime - startTime) + "ms");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
    }
}
