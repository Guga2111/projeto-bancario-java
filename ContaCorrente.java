import java.util.Scanner;
import java.util.Random;

// definição da classe:
public class ContaCorrente {
    String[] contasBancarias;
    int[] idades;
    String[] cpfs;
    String[] nomes;
    double[] saldos;

    // construtor da classe:
    public ContaCorrente(String[] contasBancarias, int[] idades, String[] cpfs, String[] nomes, double[] saldos) {
        this.contasBancarias = contasBancarias;
        this.idades = idades;
        this.cpfs = cpfs;
        this.nomes = nomes;
        this.saldos = saldos;
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
            saldos[indice] += valorCreditado;
        } else {
            System.out.println("CPF inválido!");
        }
    }

    // função para saque de determinada conta (definida pelo cpf):
    void sacar(String cpf, double valorSacado) {
        int indice = buscarIndicePorCPF(cpf);
        if (indice != -1) {
            if (saldos[indice] >= valorSacado) {
                saldos[indice] -= valorSacado;
            } else {
                System.out.println("Saldo insuficiente!");
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
        System.out.println("Digite o seu cpf");
        cpfs[posicao] = scanner.nextLine();

        System.out.println("Digite agora seu nome e sua idade, respectivamente: ");
        nomes[posicao] = scanner.nextLine();
        idades[posicao] = scanner.nextInt();

        System.out.println("Agora digite seu saldo inicial: ");
        saldos[posicao] = scanner.nextDouble();

        System.out.println("Agora iremos gerar seu código bancário!");
        System.out.print("1...\n" + "2...\n" + "3...\n");
        contasBancarias[posicao] = novaString;
        System.out.println("O SEU CODIGO DE CONTA É: " + novaString);
    }

    //função apenas para consultar o saldo de determinada (através do cpf):
    void consultarSaldo(String[] cpfs, double[] saldos, String cpf) {
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
}
