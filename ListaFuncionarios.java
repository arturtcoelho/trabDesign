import java.util.ArrayList;
import java.util.Scanner;

public class ListaFuncionarios {

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


        Funcionario funcionario = new Funcionario(id, nome, tipo, endereco, numSegSocial,
                                                    deducoesFiscaisPadrao, outrasDeducoes, numTelefone,
                                                    taxaHoraria, salario, taxaComissao, limiteHoras, formaPagamento);   

        this.funcionarios.add(funcionario);
        this.proximoID++;

        System.out.println("Funcionário adicionado com sucesso. ID do funcionário: " + funcionario.getId());
        return funcionario.getId();
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
        funcionario.setLimiteHoras(limiteHoras);
    }
    
    public void excluirFuncionario(int id) {
        Funcionario funcionario = this.getFuncionario(id);
        this.funcionarios.remove(funcionario);
        funcionario.setMarcadoParaExclusao(true);
    }
    
    private Funcionario getFuncionario(int id) {
        for (Funcionario funcionario : this.funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }
}
