# Etapa 1: Compilar el proyecto
FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/maison-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
