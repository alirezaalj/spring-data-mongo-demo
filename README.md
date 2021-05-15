###Spring boot mongodb demo
This program is written using the spring boot framework, which stores some basic data at the start of the program in the mongo database. 

my website: [https://alirezaalijani.ir](https://alirezaalijani.ir "https://alirezaalijani.ir")
##### Goals
- Start learning mongodb
- Using spring data mongodb
- Using mongo template & mongo client
- Learning mongodb query
- Mongodb Many to many & one to Many & .... 

# How to use
##### Project dependencies
- maven  : [How to use or Download](https://maven.apache.org/ "How to use or Download")
- mongodb : *i suggest using docker* 
dockerhub : [https://hub.docker.com/_/mongo](https://hub.docker.com/_/mongo "https://hub.docker.com/_/mongo")

```shell
 docker run -d -p 27017:27017 --name mongodb mongo
```
- java 8 or higher

#### Run
1. go to project folder
2. start by [spring-boot-maven-plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/ "spring-boot-maven-plugin")
```shell
mvn spring-boot:run
```
3. project start on port 8080 and you can see the console for crud actions4. use this
4. command to create jar file
```shell
 mvn clean install
```
5. end
