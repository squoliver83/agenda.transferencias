# Agendamento - Transferências

Essa aplicação *fullstack* foi desenvolvida como parte técnica de uma avaliação.  
Seguindo as orientações descritas no documento enviado pela empresa, eu pude desenvolver tanto o backend como o frontend para atender os requisitos apresentados **dentro do prazo** - de forma simplificada, porém eficiente.

## 👨‍💻 Descrição Backend

- Para o backend foi criada uma **API RESTful**, desenvolvida em Java (v17), utilizando o *framework* **Spring**.
- **Arquitetura em camadas**, separando entre *controllers*, *services*, *repositories*, além de *dtos* para tráfego/exposição das informações.
- Foi utilizado banco de dados em memória (**H2**) para persistência dos dados.
- Foram incluídas validações nos campos que julguei obrigatórios e também feito o tratamento de exceções para quando algum desses campos trouxessem informações erradas.
- Foram implementados testes em todas as camadas utilizando **JUnit/Mockito**.

### 🛠️ Executando o backend
- Após fazer o download do projeto, abra a pasta **backend** na sua IDE de preferência. Execute-o e ele ficará disponível para ser acessado no endereço: http://localhost:8081  
- O sistema está implementado com um *seed* básico, já contendo 2 agendamentos cadastrados na base de dados em memória.
- As requisições, por sua vez, estão disponíveis em **/api/agendamentos**.

## 🌐 Descrição Frontend

- Obs: O *frontend* pra mim, nesse momento, ainda é uma área de estudos.
- Ainda assim, eu procurei por cursos rápidos (*crash-courses*) sobre a linguagem desejada/sugerida na documentação (**Vue.js**) e acabei encontrando [**um**](https://www.youtube.com/watch?v=qZXt1Aom3Cs) que me auxiliou no desenvolvimento de uma aplicação básica.  
- A partir dessa aplicação básica, eu pude adaptar os componentes, acrescentar e alterar rotinas e validações, até cumprir aos requisitos do projeto (além de incluir algumas coisas mais estéticas, mas que auxiliam na usabilidade).

### 🛠️ Executando o frontend
- Como se trata de um mono-repositório, basta abrir na IDE a pasta **frontend** e executar através do comando ``npm run serve``
- O sistema executará e ficará disponível para ser acessado no endereço http://localhost:3000
- Na tela inicial do sistema estarão disponíveis os agendamentos já cadastrados (via *seed*, no *backend*) bem como a opção de cadastrar um novo agendamento de transferências - a partir do botão **Agendar**.
