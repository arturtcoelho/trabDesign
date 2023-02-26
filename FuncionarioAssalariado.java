public class FuncionarioAssalariado extends Funcionario {
    private double salarioSemanal;

    public FuncionarioAssalariado(int id, String nome, String tipo, String endereco, String numSegSocial,
                                  double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
                                  double salarioSemanal, TipoPagamento tipoPagamento) {
        super(id, nome, tipo, endereco, numSegSocial, deducoesFiscaisPadrao, outrasDeducoes, numTelefone, tipoPagamento);
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public double calcularSalario() {
        return this.salarioSemanal;
    }

    @Override
    public String toString() {
        return "FuncionarioAssalariado{" +
                "salarioSemanal=" + salarioSemanal +
                "} " + super.toString();
    }
}