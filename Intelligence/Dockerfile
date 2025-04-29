
    FROM azul/zulu-openjdk:21-latest AS build
    RUN apt-get update && apt-get install -y maven
    WORKDIR /app
    COPY pom.xml .
    COPY src ./src
    RUN mvn clean package -DskipTests

    FROM azul/zulu-openjdk:21-latest
    WORKDIR /
    COPY --from=build /app/target/*.jar irs.jar
    EXPOSE 9292
    ENTRYPOINT ["java", "-jar", "irs.jar"]
