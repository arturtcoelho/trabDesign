import java.util.Scanner;

public class Funcionario {

    private int id;
    private String nome;
    private String tipo;
    private String endereco;
    private String numSegSocial;
    private double deducoesFiscaisPadrao;
    private double outrasDeducoes;
    private String numTelefone;
    private double limiteHoras;
    private boolean marcadoParaExclusao;
    private TipoPagamento pagamento;
    private ListaCartaoPontos cartoesPonto;
    
    public Funcionario(int id, String nome, String tipo, String endereco, String numSegSocial,
    double deducoesFiscaisPadrao, double outrasDeducoes, String numTelefone,
    double taxaHoraria, double salario, double taxaComissao, double limiteHoras, TipoPagamento formaPagamento) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.endereco = endereco;
        this.numSegSocial = numSegSocial;
        this.deducoesFiscaisPadrao = deducoesFiscaisPadrao;
        this.outrasDeducoes = outrasDeducoes;
        this.numTelefone = numTelefone;
        this.limiteHoras = limiteHoras;
        this.marcadoParaExclusao = false;
        this.pagamento = formaPagamento;
    }

    public ListaCartaoPontos getCartoesPonto() {
        return cartoesPonto;
    }

    public void setCartoesPonto(ListaCartaoPontos cartoesPonto) {
        this.cartoesPonto = cartoesPonto;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(String numSegSocial) {
        this.numSegSocial = numSegSocial;
    }

    public double getDeducoesFiscaisPadrao() {
        return deducoesFiscaisPadrao;
    }

    public void setDeducoesFiscaisPadrao(double deducoesFiscaisPadrao) {
        this.deducoesFiscaisPadrao = deducoesFiscaisPadrao;
    }

    public double getOutrasDeducoes() {
        return outrasDeducoes;
    }

    public void setOutrasDeducoes(double outrasDeducoes) {
        this.outrasDeducoes = outrasDeducoes;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    // métodos get e set para limiteHoras
    public double getLimiteHoras() {
        return limiteHoras;
    }

    public void setLimiteHoras(double limiteHoras) {
        this.limiteHoras = limiteHoras;
    }

    // métodos get e set para marcadoParaExclusao
    public boolean isMarcadoParaExclusao() {
        return marcadoParaExclusao;
    }

    public void setMarcadoParaExclusao(boolean marcadoParaExclusao) {
        this.marcadoParaExclusao = marcadoParaExclusao;
    }

    // métodos get e set para formaPagamento
    public TipoPagamento getTipoPagamento() {
        return this.pagamento;
    }

    public void selecionarFormaPagamento(String metodoPagamento) {
        this.pagamento = new TipoPagamento();
        Scanner scanner = new Scanner(System.in);
        if (metodoPagamento.equals("correio")) {
            System.out.println("Por favor, informe o endereço para envio do cheque:");
            String endereco = scanner.nextLine();
            this.pagamento.setCorreio(endereco);;
        } else if (metodoPagamento.equals("deposito")) {
            System.out.println("Por favor, informe o nome do banco:");
            String nomeBanco = scanner.nextLine();
            System.out.println("Por favor, informe o número da conta:");
            String numeroConta = scanner.nextLine();
            this.pagamento.setDeposito(nomeBanco, numeroConta);        
        } else {
            System.out.println("Método de pagamento inválido!");
        }
        scanner.close();
    }

    public double calcularSalario() {
        return 0;
    }

    public double calcularPagamento() {
        return (this.calcularSalario() - this.getDeducoesFiscaisPadrao()) - this.getOutrasDeducoes();
    }
}
