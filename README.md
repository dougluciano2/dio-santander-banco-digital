# Banco Digital OO - Desafio DIO Santander

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-red?logo=apachemaven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-1.18.32-purple?logo=projectlombok&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

**Desenvolvido por:** [dougluciano2](https://github.com/dougluciano2) | Digital Innovation One (DIO)

## 📫 Como me encontrar

[![LinkedIn](https://img.shields.io/badge/LinkedIn-DouglasLuciano-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/douglasluciano/)
[![GitHub](https://img.shields.io/badge/GitHub-douglasluciano-black?style=for-the-badge&logo=github)](https://github.com/douglasluciano)
[![Portfólio](https://img.shields.io/badge/Portf%C3%B3lio-GitHub%20Pages-blueviolet?style=for-the-badge&logo=github)](https://dougluciano2.github.io)

## 📖 Sobre o Projeto

Este projeto é uma implementação aprimorada e modernizada do desafio de programação **"Criando um Banco Digital com Java e Orientação a Objetos"**, proposto pela [Digital Innovation One (DIO)](https://www.dio.me/).

A partir do problema original, o código foi completamente refatorado para incorporar melhores práticas de design de software, princípios S.O.L.I.D. e recursos modernos do ecossistema Java, transformando um exercício básico em uma aplicação de console robusta, coesa e de fácil manutenção.

## ✨ Funcionalidades Principais

* **Menu Interativo via Console:** Uma interface de usuário simples e intuitiva para interagir com o sistema bancário.
* **Abertura de Contas:** Criação de Contas Corrente e Poupança de forma centralizada e segura.
* **Operações Bancárias:** Funcionalidades essenciais como Depósito, Saque e Transferência entre contas.
* **Consultas e Relatórios:** Listagem de todas as contas ativas no banco e emissão de extrato bancário detalhado por conta.

## 🚀 Conceitos e Tecnologias Aplicadas

Este projeto vai além do básico, aplicando conceitos avançados de design e as ferramentas mais atuais do Java.

### Conceitos de Design

* **Orientação a Objetos (Pilares):** Uso aprofundado de Abstração, Encapsulamento, Herança e Polimorfismo.
* **Princípios S.O.L.I.D.:**
    * **Princípio da Responsabilidade Única (SRP):** Clara separação de responsabilidades entre as classes (`BankApp` para interação, `Bank` para serviços, `Account` para regras da conta).
    * **Princípio Aberto/Fechado:** O design com `enums` e `Factory` permite a adição de novos tipos de conta com o mínimo de alteração no código existente.
* **Design Patterns (Padrões de Projeto):**
    * **Factory Method:** Para a criação centralizada e desacoplada de diferentes tipos de contas através da classe `Bank`.
    * **Template Method:** Utilizado para definir a estrutura de algoritmos (como a emissão de extratos), permitindo que as subclasses forneçam implementações específicas de forma polimórfica.
    * **Facade:** A classe `Bank` atua como uma fachada, oferecendo uma interface simples para operações complexas como transferências.
* **Clean Code:** Foco em nomes de variáveis e métodos claros, organização de pacotes por contexto e alta coesão.

### Tecnologias

* **Java 21:** Utilização de recursos modernos da linguagem.
* **Maven:** Gerenciador de dependências e automação de build.
* **Lombok:** Para redução de código boilerplate (getters, construtores, etc.), resultando em classes de modelo mais limpas.

## 📋 Pré-requisitos

Para executar este projeto em sua máquina local, você precisará ter os seguintes softwares instalados:

* **Java Development Kit (JDK) 21** ou superior.
* **Apache Maven 3.9+** configurado nas variáveis de ambiente do seu sistema.
* **Git** para clonar o repositório.

## ⚡ Como Executar o Projeto

Siga os passos abaixo para executar a aplicação via terminal:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/dougluciano2/dio-santander-banco-digital.git](https://github.com/dougluciano2/dio-santander-banco-digital.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd dio-santander-banco-digital
    ```

3.  **Compile o projeto e execute a aplicação com o Maven:**
    O `pom.xml` já está configurado com o `exec-maven-plugin`. Use o seguinte comando:
    ```bash
    mvn compile exec:java
    ```

Após a execução, o menu interativo do banco digital será exibido no seu console.

## ஸ்ட் Estutura do Projeto

A organização dos pacotes foi feita por contexto de negócio, visando alta coesão e baixo acoplamento.

```
.
├── pom.xml
└── src
    └── main
        └── java
            └── br
                └── com
                    └── dougluciano
                        └── digitalbank
                            ├── Main.java           # Ponto de entrada (chama o App)
                            ├── BankApp.java        # Orquestrador do fluxo da aplicação
                            ├── accounts
                            │   ├── Account.java        # Classe abstrata
                            │   ├── AccountOps.java     # Interface (Contrato)
                            │   ├── CheckingAccount.java
                            │   └── SavingsAccount.java
                            ├── bank
                            │   └── Bank.java           # Classe de serviço (Facade)
                            ├── customer
                            │   └── Customer.java
                            └── enums
                                └── AccountType.java    # Enum para tipos de conta
```

## ✒️ Autor

* **Douglas Luciano** - [dougluciano2](https://github.com/dougluciano2)
