import java.util.Scanner;

import java.util.ArrayList;

public class Funcionario {

    private int id;
    private String nome;
    private String tipo;
    private String endereco;
    private String numSegSocial;
    private double deducoesFiscaisPadrao;
    private double outrasDeducoes;
    private String numTelefone;
    private double taxaHoraria;
    private double salario;
    private double taxaComissao;
    private double limiteHoras;
    private boolean marcadoParaExclusao;
    private String formaPagamento;
    
    public Funcionario(int id, String nome, String tipo, String endereco, String numSegSocial,
                        double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
                        double taxaHoraria, double salario, double taxaComissao, double limiteHoras) {
    }

    private ArrayList<Funcionario> funcionarios;
    private int proximoID;
    
    public int adicionarFuncionario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário:");
        String nome = input.nextLine();
        System.out.println("Informe o tipo de funcionário (1 - Horista, 2 - Assalariado, 3 - Comissionado):");
        int tipo = input.nextInt();
        input.nextLine();
        System.out.println("Informe o endereço para correspondência:");
        String endereco = input.nextLine();
        System.out.println("Informe o número da Segurança Social:");
        int numSegurancaSocial = input.nextInt();
        System.out.println("Informe as deduções fiscais padrão:");
        double deducoesFiscaisPadrao = input.nextDouble();
        System.out.println("Informe outras deduções (401k, médicas):");
        double outrasDeducoes = input.nextDouble();
        input.nextLine();
        System.out.println("Informe o número de telefone:");
        String numTelefone = input.nextLine();
        double taxaHoraria = 0.0;
        double salario = 0.0;
        double taxaComissao = 0.0;
        int limiteHoras = 0;
        if (tipo == 1) {
        System.out.println("Informe a taxa horária:");
        taxaHoraria = input.nextDouble();
        } else if (tipo == 2) {
        System.out.println("Informe o salário:");
        salario = input.nextDouble();
        } else if (tipo == 3) {
        System.out.println("Informe a taxa de comissão:");
        taxaComissao = input.nextDouble();
        }
        System.out.println("Informe o limite de horas extras (caso aplicável):");
        limiteHoras = input.nextInt();
        input.nextLine();


        Funcionario funcionario = new Funcionario(this.proximoID, nome, tipo, endereco, numSegSocial,
                                                  deducoesFiscaisPadrao, outrasDeducoes, numTelefone,
                                                  taxaHoraria, salario, taxaComissao, limiteHoras);

        this.funcionarios.add(funcionario);
        this.proximoID++;

        System.out.println("Funcionário adicionado com sucesso. ID do funcionário: " + funcionario.getId());
        return funcionario.getID();
    }
    
    public void atualizarFuncionario(int id, String nome, String tipo, String endereco, String numSegSocial,
                                     double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
                                     double taxaHoraria, double salario, double taxaComissao, double limiteHoras) {
        Funcionario funcionario = this.getFuncionario(id);
        funcionario.setNome(nome);
        funcionario.setTipo(tipo);
        funcionario.setEndereco(endereco);
        funcionario.setNumSegSocial(numSegSocial);
        funcionario.setDeducoesFiscaisPadrao(deducoesFiscaisPadrao);
        funcionario.setOutrasDeducoes(outrasDeducoes);
        funcionario.setNumTelefone(numTelefone);
        funcionario.setTaxaHoraria(taxaHoraria);
        funcionario.setSalario(salario);
        funcionario.setTaxaComissao(taxaComissao);
        funcionario.setLimiteHoras(limiteHoras);
    }
    
    public void excluirFuncionario(int id) {
        Funcionario funcionario = this.getFuncionario(id);
        this.funcionarios.remove(funcionario);
        funcionario.setMarcadoParaExclusao(true);
    }
    
    private Funcionario getFuncionario(int id) {
        for (Funcionario funcionario : this.funcionarios) {
            if (funcionario.getID() == id) {
                return funcionario;
            }
        }
        return null;
    }

    private int getID() {
        return this.id;
    }

    public void selecionarFormaPagamento(String metodoPagamento) {
        this.formaPagamento = metodoPagamento;
        if (metodoPagamento.equals("correio")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, informe o endereço para envio do cheque:");
            String endereco = scanner.nextLine();
            this.enderecoCheque = endereco;
        } else if (metodoPagamento.equals("deposito direto")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, informe o nome do banco:");
            String nomeBanco = scanner.nextLine();
            System.out.println("Por favor, informe o número da conta:");
            String numeroConta = scanner.nextLine();
            this.bancoDepositoDireto = nomeBanco;
            this.contaDepositoDireto = numeroConta;
        } else {
            System.out.println("Método de pagamento inválido!");
        }
    }

}
