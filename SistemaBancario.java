import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class SistemaBancario {

    public static void exibirMenuCorrente() {
        System.out.println("-------------------------");
        System.out.println("DIGITE A OPÇÃO DESEJADA: \n");
        System.out.println("1 - GERAR UMA NOVA CONTA.");
        System.out.println("2 - CONSULTAR SALDO.");
        System.out.println("3 - EFETUAR DEPÓSITO.");
        System.out.println("4 - EFETUAR SAQUE.");
        System.out.println("5 - CONSULTAR DADOS DA SUA CONTA.");
        System.out.println("0 - SAIR DO PROGRAMA\n");
        System.out.println("-------------------------");

    }

    public static void exibirMenu(){
        System.out.println("------------------------");
        System.out.println("DIGITE A OPÇÃO DESEJADA: \n");
        System.out.println("1 - CONTA CORRENTE.");
        System.out.println("2 - CONTA POUPANÇA.");
        System.out.println("0 - SAIR DO PROGRAMA\n");
        System.out.println("------------------------");
    }

    public static void exibirMenuPoupanca(){
        System.out.println("------------------------");
        System.out.println("DIGITE A OPÇÃO DESEJADA: \n");
        System.out.println("1 - GERAR UMA NOVA CONTA.");
        System.out.println("2 - CONSULTAR SALDO.");
        System.out.println("3 - EFETUAR DEPÓSITO.");
        System.out.println("4 - EFETUAR SAQUE.");
        System.out.println("5 - CONSULTAR DADOS DA SUA CONTA.");
        System.out.println("6 - APLICAR JUROS A SEU SALDO: ");
        System.out.println("0 - SAIR DO PROGRAMA\n");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // inicialização do scanner:
        Scanner scanner = new Scanner(System.in);

        // inicialização das variaveis:
        String[] contaBancariasCorrente = new String[100];
        String[] nomesCorrente = new String[100];
        int[] idadesCorrente = new int[100];
        String[] cpfsCorrente = new String[100];
        double[] saldosCorrente = new double[100];

        String[] contaBancariasPoupanca = new String[100];
        String[] nomesPoupanca = new String[100];
        int[] idadesPoupanca = new int[100];
        String[] cpfsPoupanca = new String[100];
        double[] saldosPoupanca = new double[100];

        //definindo a taxa de juros em conta poupanca:
        double juros = 0.05;

        int contasNumerosCorrente = 0;
        int contasNumerosPoupanca = 0;
        int opcao;
        int opcao2;


        ContaCorrente contas = new ContaCorrente(contaBancariasCorrente, idadesCorrente, cpfsCorrente, nomesCorrente, saldosCorrente);
        ContaPoupanca contas2 = new ContaPoupanca(contaBancariasPoupanca, idadesPoupanca, cpfsPoupanca, nomesPoupanca, saldosPoupanca, juros);

        // seletor da interface com switch case:

        int opcaoContas;
        do {
            exibirMenu();
            opcaoContas = scanner.nextInt();
            switch (opcaoContas) {
                case 1:
                    do {
                        exibirMenuCorrente();
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1:
                                contas.gerarConta(cpfsCorrente, contaBancariasCorrente, nomesCorrente, idadesCorrente, saldosCorrente, contasNumerosCorrente);
                                contasNumerosCorrente++;
                                break;
                            case 2:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf1 = scanner.nextLine();
                                contas.consultarSaldo(saldosCorrente, cpf1);
                                break;
                            case 3:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf2 = scanner.nextLine();
                                System.out.println("Digite quanto voce deseja creditar: ");
                                double valorDepositado = scanner.nextDouble();
                                contas.creditar(cpf2, valorDepositado);
                                break;
                            case 4:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf3 = scanner.nextLine();
                                System.out.println("Digite o valor que voce deseja sacar: ");
                                double valorSacado = scanner.nextDouble();
                                contas.sacar(cpf3, valorSacado);
                                break;
                            case 5:
                                System.out.println("Digite o codigo ta conta: ");
                                scanner.nextLine();
                                String codigoConta = scanner.nextLine();
                                contas.consultarDados(cpfsCorrente, nomesCorrente, idadesCorrente, contaBancariasCorrente, saldosCorrente, codigoConta);
                                break;
                            case 0:
                                System.out.println("Encerrando a interface...");
                                break;
                            default:
                                System.out.println("Opção inválida!!!");
                                break;
                        }
                    } while (opcao != 0);
                    break;
                case 2:
                    do {
                        exibirMenuPoupanca();
                        opcao2 = scanner.nextInt();
                        switch (opcao2) {
                            case 1:
                                contas2.gerarConta(cpfsPoupanca, contaBancariasPoupanca, nomesPoupanca, idadesPoupanca, saldosPoupanca, contasNumerosPoupanca);
                                contasNumerosPoupanca++;
                                break;
                            case 2:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf1 = scanner.nextLine();
                                contas2.consultarSaldo(saldosPoupanca, cpf1);
                                break;
                            case 3:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf2 = scanner.nextLine();
                                System.out.println("Digite quanto voce deseja creditar: ");
                                double valorDepositado = scanner.nextDouble();
                                contas2.creditar(cpf2, valorDepositado);
                                break;
                            case 4:
                                System.out.println("Digite seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf3 = scanner.nextLine();
                                System.out.println("Digite o valor que voce deseja sacar: ");
                                double valorSacado = scanner.nextDouble();
                                contas2.sacar(cpf3, valorSacado);
                                break;
                            case 5:
                                System.out.println("Digite o codigo ta conta: ");
                                scanner.nextLine();
                                String codigoConta = scanner.nextLine();
                                contas2.consultarDados(cpfsPoupanca, nomesPoupanca, idadesPoupanca, contaBancariasPoupanca, saldosPoupanca, codigoConta);
                                break;
                            case 6:
                                System.out.println("Digite o seu cpf, para acessar sua conta: ");
                                scanner.nextLine();
                                String cpf4 = scanner.nextLine();
                                System.out.println("Agora digite a quantidade de meses que o juros foi aplicado: ");
                                int mes = scanner.nextInt();
                                contas2.calcularJuros(cpf4, saldosPoupanca, juros, mes);
                                break;
                            case 0:
                                System.out.println("Encerrando a interface...");
                                break;
                            default:
                                System.out.println("Opção inválida!!!");
                                break;
                        }
                    } while (opcao2 != 0);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (opcaoContas != 0);

        //geração de arquivo:
        String nomeArquivo = "resultados.txt";
        String[] temporarioSaldosCorrente = new String[100];
        String[] temporarioSaldosPoupanca = new String[100];


        try {
            FileWriter escritor = new FileWriter(nomeArquivo);
            DecimalFormat formato = new DecimalFormat("#0.00");
            escritor.write("OS SALDOS DE CADA CONTA CORRENTE SERÃO EXIBIDOS A SEGUIR: \n\n");
            for (int i = 0; i < contasNumerosCorrente; i++) {

                String j = String.valueOf(i + 1);

                escritor.write(j);
                escritor.write(" - ");
                escritor.write("CPF: ");
                escritor.write(cpfsCorrente[i]);
                escritor.write(" - ");
                temporarioSaldosCorrente[i] = formato.format(saldosCorrente[i]);
                escritor.write(temporarioSaldosCorrente[i]);
                escritor.write("\n");

            }
            escritor.write("\nOS SALDOS DE CADA CONTA POUPANCA SERÃO EXIBIDOS A SEGUIR: \n\n");
            for (int x = 0; x < contasNumerosPoupanca; x++){
                System.out.println("OK!");
                String y = String.valueOf(x+1);

                escritor.write(y);
                escritor.write(" - ");
                escritor.write("CPF: ");
                escritor.write(cpfsPoupanca[x]);
                escritor.write(" - ");
                temporarioSaldosPoupanca[x] = formato.format(saldosPoupanca[x]);
                escritor.write(temporarioSaldosPoupanca[x]);
                escritor.write("\n");
            }
            escritor.close();
            System.out.println("Foi concluido com sucesso a geração do arquivo!");
        } catch (IOException e) {
            System.out.println("Deu erro na geração do arquivo txt");
        }
        // fechamento do scanner:
        scanner.close();
    }
}
