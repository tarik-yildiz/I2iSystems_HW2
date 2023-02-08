# HAZELCAST IMDG PERFORMANCE TEST
## HAZELCAST 
- [Download Hazelcast PLATFORM 5.1](https://github.com/hazelcast/hazelcast/releases/download/v5.1/hazelcast-5.1.zip)  
- [Download Hazelcast Management Center IMDG 5.1.1](https://repository.hazelcast.com/download/management-center/hazelcast-management-center-5.1.1.zip)
### INSTALLATION
- Unzip Hazelcast 5.1 and open folder in powershell. Execute:

            $ .\bin\hz-start

- Unzip Hazelcast Management Center IMDG 5.1.1 and open folder in powershell. Execute:

            $ .\bin\mc-start.cmd

## JAVA
- Open your project and find *pom.xml* in your project files.
- Add dependencies to pom.xml file.

                <dependencies>
                    <dependency>
                        <groupId>com.hazelcast</groupId>
                        <artifactId>hazelcast</artifactId>
                        <version>5.2.1</version>
                    </dependency>
                </dependencies>         
- Build your project.

