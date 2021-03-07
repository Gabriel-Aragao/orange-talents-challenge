# Orange Talents Challenge

This repository contains the code for a challenge that I received as the second stage of recruiting Orange Talents from Zup.

## The challenge instructions
This section will be in Portuguese because I received it this way. However, in simple words, I was required to describe in a blog post format how I would model a Spring REST API that registers patients and vaccines.
Vamos às instruções!

 
### Contexto:

Você está fazendo uma API REST que precisará controlar a aplicação de vacinas entre a população brasileira. O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatórios dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.

O segundo passo é criar um cadastro de aplicação de vacinas, sendo obrigatórios dados como: nome da vacina, e-mail do usuário e a data que foi realizada a vacina.

Você deve construir apenas dois endpoints neste sistema, o cadastro do usuário e o cadastro da aplicação da vacina. Caso os cadastros estejam corretos, é necessário voltar o Status 201, caso hajam erros de preenchimento de dados, o Status deve ser 400.

### Seu desafio:

Dado que você fosse implementar esse sistema utilizando Java como linguagem e Spring + Hibernate como stacks de tecnologia fundamentais da aplicação: Escreva um post de blog explicando de maneira detalhada tudo que você faria para implementar esse código. 

No texto, queremos que você:

Explique quais as tecnologias do mundo Spring você usaria;

Conte qual o papel das tecnologias escolhidas e quais benefícios elas trazem para a implementação do código;

Diga quais classes seriam criadas nesse processo e traga trechos autorais explicando a construção de cada classe do código;

Explique as etapas do processo de construção do seu código e como faria a implementação do sistema na Web;

Traga trechos de códigos autorais que justifiquem a implementação de cada tecnologia (não precisamos do código inteiro);
Os itens acima são obrigatórios, mas não se limite. Se quiser escrever mais, fique à vontade (não existe quantidade máxima de páginas ou caracteres).
 

### Dicas:

Não precisamos saber como instalar cada ferramenta, queremos saber como você implementaria o seu código.

Ao justificar as tecnologias, mostre a sua visão e entendimento de cada uma e não conceitos prontos já conhecidos.

Cite as tecnologias que você utilizaria em seu projeto e porquê elas fazem parte do escopo/construção do seu código, pois ficaremos de olho nesse ponto.

Suas classes e atributos podem ser em português ou em inglês, não se apegue a isso, queremos um bom resultado final.

Não queremos um manual de programação e sim um post explicando como você faria a implementação da API passo a passo.

Mais do que respostas certas, queremos ver o quão nerd você consegue ser e o que considera relevante. O importante é mostrar que consegue aprender, se fazer entender e ainda transmitir conhecimento.

### Se ficou fácil, te desafiamos a:

Construir a aplicação sem utilizar Lombok;
Substituir o e-mail do usuário na tabela de vacinação para uma chave estrangeira associada ao id do usuário. 