public class FuncionarioHorista extends Funcionario {
    private double horasTrabalhadas;
    private double precoHora;

    public FuncionarioHorista(int id, String nome, String tipo, String endereco, String numSegSocial,
                              double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
                              double horasTrabalhadas, double precoHora) {
        super(id, nome, tipo, endereco, numSegSocial, deducoesFiscaisPadrao, outrasDeducoes, numTelefone);
        this.horasTrabalhadas = horasTrabalhadas;
        this.precoHora = precoHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    @Override
    public double calcularSalario() {
        double salario = horasTrabalhadas * precoHora;
        double imposto = calcularImposto(salario);
        return salario - imposto;
    }

    @Override
    public String toString() {
        return "FuncionarioHorista{" +
                "horasTrabalhadas=" + horasTrabalhadas +
                ", precoHora=" + precoHora +
                "} " + super.toString();
    }
}