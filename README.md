# Integração com HubSpot

Este projeto realiza a integração com a API do HubSpot. Ele está configurado para ser executado dentro de um container Docker e expõe a porta 8080.

## Pré-requisitos

Antes de rodar o projeto, verifique se você tem os seguintes pré-requisitos instalados:

- [Docker](https://www.docker.com/get-started)
- [Git](https://git-scm.com/)

## Rodando o Projeto

1. Clone o repositório para a sua máquina local:

   ```bash
   git clone https://github.com/GiovanniRS/Integracao-com-HubSpot.git

2. Navegue até o diretório do projeto:

   ```bash
   cd Integracao-com-HubSpot

3. Execute o script run.sh para subir o container Docker:

   ```bash
   ./run.sh

4. Após o container estar em execução, você pode acessar a aplicação na seguinte URL:

   ```bash
   http://localhost:8080/auth/authorize
