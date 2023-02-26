import java.util.ArrayList;
import java.util.List;

public class FolhaPagamento {
    
    ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    int proximoID = 1;

    public void executarFolhaDePagamento() {
        
        //1. Recupera todos os funcionários que devem ser pagos na data atual
        List<Funcionario> funcionarios = recuperaFuncionariosDaDataAtual();
        
        for(Funcionario funcionario : funcionarios) {
            
            //2. Calcula o pagamento usando cartões de ponto inseridos, ordens de compra, informações do funcionário e todas as deduções legais
            double pagamento = funcionario.calcularPagamento();
            
            funcionario.getTipoPagamento().executarPagamento(pagamento);
            
            //5. Exclui o funcionário se ele foi marcado para exclusão
            if(funcionario.isMarcadoParaExclusao()) {
                excluirFuncionario(funcionario);
            }
        }
    }
    
    private List<Funcionario> recuperaFuncionariosDaDataAtual() {
        return this.listaFuncionarios;
    }
    
    private void excluirFuncionario(Funcionario funcionario) {
        this.listaFuncionarios.remove(funcionario);
    }
}