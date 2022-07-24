<h1 align="center"> <a href="https://youtu.be/WdT90ffB-0Q">A primeira Imersão Java da Alura!</a></h1>


Projeto de estudo desenvolvido durante uma semana intensa de aprendizados e desafios, consumindo e criando APIs com Java, para depois transformar em figurinhas do WhatsApp.


## ✔️ Técnicas e tecnologias utilizadas
- `Java`: Consumir APIs e gerar figurinhas
- `Spring Boot`: BackEnd
- `Heroku`: Cloud que hospeda nossa aplicação
- `MongoDB`: Salvando nossas figurinhas em um banco de dados não relacional
- `Kotlin` / `Jetpack Compose`: Aplicativo Android que consome nossa API

## [Extra](https://github.com/git-jr/DevHub/tree/api-alura)
Como desafio pessoal extra, adaptei o [app Android](https://github.com/git-jr/DevHub) desenvolvido durante #7DaysOfCode de Kotlin com Jetpack Compose para lidar com nossa API.
Além de listar as figurinhas, você pode votar na que mais gostar. 
> :construction: Tentando fazer elas irem direto para o WhatsApp:construction:

<img src="https://github.com/K6pkus/Imgs/blob/main/amostra-devHub-api-alura.gif?raw=true" alt="api_tester_demo1" width="300">

## [Dia 1](https://github.com/git-jr/sticker-doxo-alura/tree/7e8fa690883302f7433abe4d1191aae77580ddf6)
##### Consumindo API do IMDB e similares; Peronlizando a saida dos dados;
Fiz com que se a nota do IMDB for maior que 5.5 ele exibe a avaliação em estrelas ⭐, abaixo disso, em tomates 🍅

## [Dia 2](https://github.com/git-jr/sticker-doxo-alura/tree/46b21bf1d1e23be49ca87e22d8b9318e094f3b1b)
##### Baixando imagens dos filmes para criar figurinha
- Desafio: Customizar a formatação das imagens para transforma-las em figurinhas do WhatsApp.
- Fiz as imagens serem formatadas com cara de memes, o texto a ser inserido é selecionado aleatoriamente (mas nem sempre 👀)

<img src="https://pbs.twimg.com/media/FYEsk0RWYAAvf4w?format=jpg&name=medium" alt="Imagem mostrando figurinhas e terminal emojis" width="600">
<img src="https://pbs.twimg.com/media/FYEs1d0XEAQrR_O?format=png&name=small" alt="Figurinha" width="250">



## [Dia 3](https://github.com/git-jr/sticker-doxo-alura/tree/29d46861600c5a9bb9a82cc2fa909ca36972e4a0)
##### Refatorando código, repensando competências e usando a API da Nasa 🚀

- Desafios:
- [x] Transformar a classe que representa os conteúdos em um Record
- [x] Criar exceção customizada
- [x] Criar uma Enum para URL das APIs
- [ ] Mapear listas com  Streams ou Lambdas
- [ ] Desafio Supremo: Consumir outras APIs com retornos diferentes

## [Dia 4](https://github.com/git-jr/sticker-doxo-alura/tree/7c7bcc586ee00f5c490f4da5de2fc8e5bbaab368)
##### Talvez o melhor dia até agora, criamos uma [API com Spring Boot e MongoDB](https://github.com/git-jr/api-sticker-doxo-alura) para usar na criação das figurinhas

- Desafios:
- [x] Finalizar o CRUD
- [x] Devolver a listagem ordenada pelo ranking
- [x] Retornar o status 201 quando um POST é feito
- [ ] Criar DTO para "traduzir" as primeiras inserções com nomes diferentes da API 
- [ ] Desafio Supremo: Aplicar modificações parciais no recurso através do método PATCH, por exemplo, modificando o número de votos a cada acesso


## Dia 5
##### Fizemos o deploy da API criada para o cloud Heroku, teste ela aqui:

https://sticker-doxo-api.herokuapp.com/linguagens






