public class TipoPagamento {

    private String tipo;
    private String endereco;
    private String banco;
    private String conta;

    public TipoPagamento() {}
    public TipoPagamento(String endereço) {
        this.endereco = endereço;
        this.tipo = "correio";
    }
    public TipoPagamento(String banco, String conta) {
        this.conta = conta;
        this.banco = banco;
        this.tipo = "deposito";
    }

    // getters e setters
    public void setCorreio(String endereço) {
        this.endereco = endereço;
        this.tipo = "correio";
    }

    public void setDeposito(String banco, String conta) {
        this.conta = conta;
        this.banco = banco;
        this.tipo = "deposito";
    }
    
    public String getTipo() {
        return this.tipo;
    }

    public String getEndereco() {
        if (this.tipo.equals("correio")) {
            return this.endereco;
        }
        return null;
    }

    public String getBanco() {
        if (this.tipo.equals("deposito")) {
            return this.banco;
        }
        return null;
    }

    public String getConta() {
        if (this.tipo.equals("deposito")) {
            return this.conta;
        }
        return null;
    }

    public void executarPagamento(double valor) {
        if (this.tipo == "correio") {
            System.out.println("Executado pagamento para endereço: "+this.endereco);
        } else {
            System.out.println("Executado pagamento para banco: "+this.banco+" Conta: "+this.conta);
        }
        System.out.println("Valor pago:"+valor);
    }

}