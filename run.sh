APP_NAME="hubspot-0.0.1-SNAPSHOT"
IMAGE_NAME="hubspot"

./mvnw clean package

if [ ! -f "target/$APP_NAME.jar" ]; then
    echo "Erro: Não foi possível encontrar o arquivo JAR em target/$APP_NAME.jar"
    exit 1
fi

echo "### Arquivo JAR gerado com sucesso: target/$APP_NAME.jar"

echo "### Construindo a imagem Docker '$IMAGE_NAME'..."
docker build -t $IMAGE_NAME .

echo "### Executando o container Docker..."
docker run -p 8080:8080 $IMAGE_NAME

echo "### Container Docker rodando na porta 8080. Acesse via http://localhost:8080"