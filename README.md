# functional-smooothies-inc

## Sumário

- [Descrição](#Descrição)
- [Pré-requisitos](#Pre-requisitos)
  - [Instalação](#Instalação)
  - [Instruções para iniciar o projeto](#Intruções-para-iniciar-o-projeto)
- [Documentação](#Documentação)
  - [Tipos de Smoothies](#Tipos-de-Smoothies)
  - [Listar Ingredientes](#Listar-Ingredientes)
  - [Remover ingredientes especificos](#Remover-ingredientes-especificos)

<br>

## Descrição

**Objetivo**: Neste projeto foi desenvolvido uma aplicação completa com front-end em javascript e React.js, um back-end em Java e SpringBoot. Essa aplicação simula uma interface de listagem de ingredientes de Smoothies.


- Arquitetura REST;
- Conseitos de SOLID e POO;
- Java 11;
- Maven;
- Javascript;
- Node.js;
- React.js;
- Testes com JUnit;
- Docker;

## Pré-requisitos

- `npm version 6.14.13`
- `node version 14.17.0`
- `openjdk 11.0.16`
- `Apache Maven 3.6.3`
- `docker version 20.10.13`
- `docker-compose version 1.29.2`

## Instalação

- Clone o repositório
  ```sh
    git clone git@github.com:esdrasoliveira5/functional-smooothies-inc.git
- Vá para a pasta da aplicação
  ```sh
    cd functional-smooothies-inc

## Instruções para iniciar o projeto

<br>

- Comando para iniciar

  ```sh
  sudo docker-compose up


- Acesse a aplicação web front-end pela rota

  ```sh
  http://localhost:5173/


- Acesse a aplicação Java Spring-Boot back-end pela rota

  ```sh
  http://localhost:8080/


<br/>

<img src="./assets/image.png">

## Documentação

 <br/>

### **Tipos de Smoothies**

<li>Classic: strawberry, banana, pineapple, mango, peach, honey</li>
<li>Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt</li>
<li>Greenie: green apple, lime, avocado, spinach, ice, apple juice</li>
<li>Just Desserts: banana, ice cream, chocolate, peanut, cherry</li>

<br/>

### **Listar Ingredientes** 
##### `POST` /ingredients/create
  <br/>

  Esse endpoint retorna uma lista de ingredientes.

  - Exemplo `request body` 
    ``` json
    {
        "ingredient": "Classic"
    }
    ```

  - Exemplo `response body`
    ```json
      {
          "ingredient": "strawberry,banana,pineapple,mango,peach,honey"
      }
    ```
  <br/>

### **Remover ingredientes especificos** 
##### `POST` /ingredients/create
  <br/>

  Esse endpoint retorna uma lista com exceção do ingrediente especificado.

  - Exemplo `request body` 
    ``` json
    {
        "ingredient": "Classic, -strawberry,-banana"
    }
    ```

  - Exemplo `response body`
    ```json
      {
          "ingredient": "pineapple,mango,peach,honey"
      }
    ```
  <br/>

<br/>
