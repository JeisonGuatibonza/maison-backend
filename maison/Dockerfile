# Usamos una imagen de Java 17
FROM eclipse-temurin:17-jdk-alpine
# Copiamos el archivo .jar que generamos anteriormente
COPY target/maison-0.0.1-SNAPSHOT.jar app.jar
# Ejecutamos la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
