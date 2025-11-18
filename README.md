## 📚 **Library Management System**

Este projeto é um sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando apenas o console. Ele permite que clientes realizem ações como buscar, emprestar e devolver livros, enquanto administradores podem gerenciar todo o acervo.

### 🚀 **Funcionalidades**

#### 👤 **Modo Cliente**

Listar livros disponíveis

Emprestar um livro

Devolver um livro

Buscar livro pelo título

#### 🛠️ **Modo Administrador**

Listar todos os livros (disponíveis ou não)

Listar todos os empréstimos ativos

Cadastrar novos livros no sistema

Cadastro automático de autores ao registrar livros

---
### 🧱 **Estrutura do Projeto**

O sistema é composto pelas classes principais:

Book → Representa um livro

Author → Representa um autor

Loan → Representa um empréstimo

Library → Centraliza operações e armazena listas de livros, autores e empréstimos

Main → Contém os menus e controla o fluxo principal do programa

---
### 📂 **Menus do Sistema**
#### 🔸 **Menu Principal**

Permite escolher o tipo de acesso:

Cliente

Administrador

Encerrar o programa

#### 🔸 **Menu Cliente**

Disponibiliza as ações destinadas ao público comum.

#### 🔸 **Menu Administrador**

Permite visualizar o acervo completo, gerenciar empréstimos e registrar novos livros.

---
### 🛡️ **Tratamento de Erros**

O sistema conta com:

Validação para evitar que o programa quebre ao digitar letras onde números são esperados

Verificação para impedir empréstimos de livros inexistentes ou indisponíveis

Prevenção contra devolução de livros que não estão emprestados

Mensagens claras de feedback ao usuário

---
### ▶️ **Como Executar**

Certifique-se de ter o Java (JDK) instalado

Compile os arquivos .java

Execute o Main.java

Escolha o modo (Cliente/Admin) e utilize o sistema pelo console