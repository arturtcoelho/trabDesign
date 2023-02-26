public class FuncionarioComissionado extends Funcionario {
    private double totalVendas;
    private double taxaComissao;

    public FuncionarioComissionado(int id, String nome, String tipo, String endereco, String numSegSocial,
                                   double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
                                   double totalVendas, double taxaComissao) {
        super(id, nome, tipo, endereco, numSegSocial, deducoesFiscaisPadrao, outrasDeducoes, numTelefone, tipoPagamento);
        this.totalVendas = totalVendas;
        this.taxaComissao = taxaComissao;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularSalario() {
        double salario = totalVendas * taxaComissao;
        double imposto = calcularImposto(salario);
        return salario - imposto;
    }

    @Override
    public String toString() {
        return "FuncionarioComissionado{" +
                "totalVendas=" + totalVendas +
                ", taxaComissao=" + taxaComissao +
                "} " + super.toString();
    }

}