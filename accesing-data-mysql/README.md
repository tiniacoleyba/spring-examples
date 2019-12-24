##  Notes

- Build: `mvn clean install package`
- Run: `java -jar target/accesing-data-mysql-0.0.1-SNAPSHOT.jar`
- Run: `mvn spring-boot:run`
- Test: `curl localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com`
- Test: `curl localhost:8080/demo/all`

Example extracted from [here](https://spring.io/guides/gs/accessing-data-mysql/)
