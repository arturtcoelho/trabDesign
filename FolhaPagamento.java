import java.util.ArrayList;
import java.util.List;

import Funcionario;

public class FolhaPagamento {
    
    ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    int proximoID = 1;

    public void executarFolhaDePagamento() {
        
        //1. Recupera todos os funcionários que devem ser pagos na data atual
        List<Funcionario> funcionarios = recuperaFuncionariosDaDataAtual();
        
        for(Funcionario funcionario : funcionarios) {
            
            //2. Calcula o pagamento usando cartões de ponto inseridos, ordens de compra, informações do funcionário e todas as deduções legais
            double salario = calcularSalario(funcionario);
            double beneficios = calcularBeneficios(funcionario);
            double deducoes = calcularDeducoes(funcionario);
            double pagamento = salario + beneficios - deducoes;
            
            //3. Se a forma de pagamento for correio, o sistema cria uma transação bancária e a envia para o Banco Sistema de processamento e envio.
            if(funcionario.getFormaDePagamento() == FormaDePagamento.CORREIO) {
                criarTransacaoBancaria(funcionario, pagamento);
                enviarTransacaoBancariaParaSistemaDeProcessamentoEEnvio();
            }
            
            //4. Se a forma de pagamento for depósito direto, o sistema cria uma transação bancária e a envia para o Sistema do Banco para processamento.
            else if(funcionario.getFormaDePagamento() == FormaDePagamento.DEPOSITO_DIRETO) {
                criarTransacaoBancaria(funcionario, pagamento);
                enviarTransacaoBancariaParaSistemaDoBancoParaProcessamento();
            }
            
            //5. Exclui o funcionário se ele foi marcado para exclusão
            if(funcionario.isMarcadoParaExclusao()) {
                excluirFuncionario(funcionario);
            }
        }
    }
    
    private List<Funcionario> recuperaFuncionariosDaDataAtual() {
        //método para recuperar os funcionários que devem ser pagos na data atual
        //retorna uma lista de funcionários
    }
    
    private double calcularSalario(Funcionario funcionario) {
        //método para calcular o salário do funcionário
        //retorna um valor double
    }
    
    private double calcularBeneficios(Funcionario funcionario) {
        //método para calcular os benefícios do funcionário
        //retorna um valor double
    }
    
    private double calcularDeducoes(Funcionario funcionario) {
        //método para calcular as deduções legais do funcionário
        //retorna um valor double
    }
    
    private void criarTransacaoBancaria(Funcionario funcionario, double pagamento) {
        //método para criar uma transação bancária para o funcionário
    }
    
    private void enviarTransacaoBancariaParaSistemaDeProcessamentoEEnvio() {
        //método para enviar a transação bancária para o sistema de processamento e envio
    }
    
    private void enviarTransacaoBancariaParaSistemaDoBancoParaProcessamento() {
        //método para enviar a transação bancária para o sistema do banco para processamento
    }
    
    private void excluirFuncionario(Funcionario funcionario) {
        //método para excluir o funcionário do sistema
    }
} FolhaPagamento {
    
}
