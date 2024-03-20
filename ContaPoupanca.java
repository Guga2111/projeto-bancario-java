import java.util.Scanner;
import java.util.Random;

// definição da classe:
public class ContaPoupanca {
    String[] contasBancarias;
    int[] idades;
    String[] cpfs;
    String[] nomes;
    double[] saldos;
    double juros;

    // construtor da classe:
    public ContaPoupanca(String[] contasBancarias, int[] idades, String[] cpfs, String[] nomes, double[] saldos, double juros) {
        this.contasBancarias = contasBancarias;
        this.idades = idades;
        this.cpfs = cpfs;
        this.nomes = nomes;
        this.saldos = saldos;
        this.juros = juros;

    }

    // função private para buscar o indice daquele determinado cpf:
    private int buscarIndicePorCPF(String cpf) {
        for (int i = 0; i < cpfs.length; i++) {
            if (cpfs[i] != null && cpfs[i].equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    // função para deposito de determinada conta (definida pelo cpf):
    void creditar(String cpf, double valorCreditado) {
        int indice = buscarIndicePorCPF(cpf);
        if (indice != -1) {
            if(valorCreditado < 0){
                System.out.println("Valor digitado inválido!");
            }else{
                saldos[indice] += valorCreditado;
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }

    // função para saque de determinada conta (definida pelo cpf):
    void sacar(String cpf, double valorSacado) {
        int indice = buscarIndicePorCPF(cpf);
        if (indice != -1) {
            if (valorSacado > 0 && saldos[indice] >= valorSacado) { // Verifica se o valor sacado é positivo e se não ultrapassa o saldo
                saldos[indice] -= valorSacado;
                System.out.println("Saque de " + valorSacado + " R$ realizado com sucesso!");
            } else if (valorSacado <= 0) {
                System.out.println("Valor inválido para saque!");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }


    // geração de conta, utilizando numeros aleatorios e transformaçoes de numeros para string e adição de uma - para representar a vida real:
    void gerarConta(String[] cpfs, String[] contasBancarias, String[] nomes, int[] idades, double[] saldos, int posicao) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        if (posicao >= cpfs.length || posicao >= contasBancarias.length || posicao >= nomes.length || posicao >= idades.length || posicao >= saldos.length) {
            System.out.println("Arrays cheias. Não é possível adicionar mais contas.");
            return;
        }

        int numeroConta = 10000 + random.nextInt(90000);
        String contaTemp = Integer.toString(numeroConta);
        String novaString = contaTemp.substring(0, 4) + "-" + contaTemp.substring(4);

        System.out.println("Vamos criar sua conta, a partir de suas informações: ");
        System.out.println("Digite o seu CPF:");
        cpfs[posicao] = scanner.nextLine();

        System.out.println("Digite agora seu nome e sua idade, respectivamente:");
        nomes[posicao] = scanner.nextLine();
        idades[posicao] = scanner.nextInt();

        System.out.println("Agora digite seu saldo inicial: ");
        double preSaldo = scanner.nextDouble();
        System.out.println("Antes do pre saldo");
        System.out.println(preSaldo);
        if(preSaldo < 0){
            preSaldo = 0;
            System.out.println("Saldo definido para 0, pois não é possivel saldo negativo!");
        }else{
            System.out.println("Aqui pre saldo igual à " + preSaldo);
        }
        saldos[posicao] = preSaldo;


        System.out.println("Agora iremos gerar seu código bancário!");
        System.out.print("1...\n" + "2...\n" + "3...\n");
        contasBancarias[posicao] = novaString;
        System.out.println("O SEU CÓDIGO DE CONTA É: " + novaString);
    }


    //função apenas para consultar o saldo de determinada (através do cpf):
    void consultarSaldo(double[] saldos, String cpf) {
        int indice = buscarIndicePorCPF(cpf);
        if (indice != -1) {
            System.out.println("O seu saldo é de: " + saldos[indice] + " R$");
        } else {
            System.out.println("CPF inválido!");
        }
    }

    //função para consultar os dados (incluindo o saldo) e dessa vez sendo apenas acessada a conta se for informado o seu codigo de conta:
    void consultarDados(String[] cpfs, String[] nomes, int[] idades, String[] contasBancarias, double[] saldos, String codigoConta) {
        for (int i = 0; i < contasBancarias.length; i++) {
            if (codigoConta.equals(contasBancarias[i])) {
                System.out.println("NOME: " + nomes[i]);
                System.out.println("IDADE: " + idades[i]);
                System.out.println("CPF: " + cpfs[i]);
                System.out.println("SALDO: " + saldos[i]);
                break;
            }
        }
    }
    void calcularJuros(String cpf, double[] saldos, double juros , int meses) {
        int indice = buscarIndicePorCPF(cpf);
        double resultado = saldos[indice] * (juros / 100.0) * meses;
        saldos[indice] += resultado;
    }
}
