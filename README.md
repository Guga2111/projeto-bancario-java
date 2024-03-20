# projeto-bancario-java
## ALUNO: LUÍS GUSTAVO OLIVEIRA SAMPAIO - 00000848988
Sistema Bancario, com algumas funcionalidades feitas.

# Requisitos Mínimos: 
- Defini em classes os tipos de contas bancárias ('ContaCorrente' e 'ContaPoupanca'), além disso a classe principal entitulada como 'SistemaBancario'. Nessas classes usufrui da implementação de Arrays para diferentes tipos de contas.
- Realizei as verificações básicas nas funcionalidades das minhas classes para que o valor da conta NUNCA ser menor do que zero ( número negativo ).

# Requisitos Adicionais:
## Bibliotecas.
- 'import java.util.Scanner;' -> Utilizei essa biblioteca para input do usúario, para armezenamento em variáveis.
- 'import java.io.FileWriter;' -> Utilizada para criação de arquivo txt.
- 'import java.io.IOException;' -> Também utilizei na lógica do arquivo txt, na verificação de input e output.
- 'import java.text.DecimalFormat;' -> Utilizada para formatação de números do tipo double.
- 'import java.util.Random;' -> Utilização para criação randômica de um número.
## Função de Criação de conta.
- Na geração da conta utilizei de artificios como 'random' objeto criado pela classe 'Random' e utilização de funções como '10000 + random.nextInt(90000);' para criar um número aleatório entre 0 e 99999.
- Ainda utilizei de um artifício de atribuir um char '-' no 5 elemento da String 'numeroConta' ,transformando-a para String previamente, e adicionando o '-' dessa forma: 'String novaString = contaTemp.substring(0, 4) + "-" + contaTemp.substring(4);'.
## Interface coligada. 
- Podendo alternar entre criação de contas correntes e de contas poupança.
## Implementação de função para exibir todos os dados de uma conta.
- Acessível apenas se usuário souber o número da conta nesse banco.
## Implementação de função que procura o indice de determinado CPF.
- Busca elemento por elemento do array de cpfs e retorna o indice do cpf solicitado, facilitando operações dentro das funções.
## Criação de arquivo txt.
- No final do programa o banco gera um arquivo txt com nome 'resultados.txt' com todos os saldos de determinadas contas.
- Implementada através da biblioteca FileWriter e IOException.
