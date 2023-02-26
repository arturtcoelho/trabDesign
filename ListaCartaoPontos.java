import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaCartaoPontos {
    private List<CartaoPonto> cartoes;

    public ListaCartaoPontos() {
        this.cartoes = new ArrayList<>();
    }

    public void adicionarCartao(CartaoPonto cartao) {
        this.cartoes.add(cartao);
    }

    public void removerCartao(CartaoPonto cartao) {
        this.cartoes.remove(cartao);
    }

    public List<CartaoPonto> getCartoes() {
        return this.cartoes;
    }

    public int getTamanho() {
        return this.cartoes.size();
    }

    public CartaoPonto getCartao(int id, int limiteHoras,  LocalDate dataInicio, LocalDate dataFim) {
        for (CartaoPonto cartao : this.cartoes) {
            if (cartao.getFuncionario() == id && cartao.getInicioPeriodo().isBefore(dataFim) && cartao.getFimPeriodo().isAfter(dataInicio)) {
                return cartao;
            }
        }
        
        // Se não encontrou nenhum cartão válido, criar um novo cartão
        CartaoPonto novoCartao = new CartaoPonto(id, limiteHoras, dataInicio, dataFim);
        this.adicionarCartao(novoCartao);
        return novoCartao;
    }

    public void limpar() {
        this.cartoes.clear();
    }
}
