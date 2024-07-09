FROM openjdk:17
LABEL maintainer ="saurabhchopade"
ADD target/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/product-0.0.1-SNAPSHOT.jar"]