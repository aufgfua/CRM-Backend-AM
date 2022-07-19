# Step 1 - Test and packageContent Security Policy: The page's settings blocked the
# Idea came from docker.com - 9 tips for containerizing spring boot code

FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline


COPY src ./src
RUN ./mvnw clean install -DskipTests


# Step 2
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/*.jar


ENTRYPOINT ["java", "-jar", "/app/*.jar"]
