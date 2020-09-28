FROM java:8
EXPOSE 8080
ADD /target/two-data-source-0.0.1.jar two-data-source.jar
ENTRYPOINT ["java", "-jar", "two-data-source.jar"]