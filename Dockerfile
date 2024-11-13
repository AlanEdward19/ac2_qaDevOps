# Use a imagem base do OpenJDK para rodar a aplicação
FROM openjdk:17

# Defina o diretório de trabalho no contêiner
WORKDIR /ac2_ca

# Copie o arquivo JAR para o contêiner em /ac2_ca
COPY target/*.jar /ac2_ca/ac2_ca-0.0.1-SNAPSHOT.jar

# Exponha a porta que sua aplicação irá rodar
EXPOSE 8585

# Especifique o comando para rodar ao iniciar o contêiner
CMD ["java", "-jar", "ac2_ca-0.0.1-SNAPSHOT.jar"]