import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartaoPonto {
    
    private int idFuncionario;
    private double limiteHoras;

    private LocalDate inicioPeriodo;
    private LocalDate fimPeriodo;
    private boolean enviado;
    private List<Cobranca> cobrancas;
    
    public CartaoPonto(int idFuncionario, int limiteHoras, LocalDate inicioPeriodo, LocalDate fimPeriodo) {
        this.idFuncionario = idFuncionario;
        this.limiteHoras = limiteHoras;
        this.inicioPeriodo = inicioPeriodo;
        this.fimPeriodo = fimPeriodo;
        this.enviado = false;
        this.cobrancas = new ArrayList<>();
    }
    
    public int getFuncionario() {
        return idFuncionario;
    }
    
    public void setFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public double getLimiteHoras() {
        return limiteHoras;
    }

    public void setLimiteHoras(double limiteHoras) {
        this.limiteHoras = limiteHoras;
    }
    
    public LocalDate getInicioPeriodo() {
        return inicioPeriodo;
    }
    
    public LocalDate getFimPeriodo() {
        return fimPeriodo;
    }
    
    public boolean isEnviado() {
        return enviado;
    }
    
    public List<Cobranca> getCobrancas() {
        return cobrancas;
    }
    
    public void adicionarCobranca(Cobranca cobranca) {
        cobrancas.add(cobranca);
    }
    
    public void atualizarHorasTrabalhadas(int numeroCobranca, LocalDate data, double horas) {
        for (Cobranca cobranca : cobrancas) {
            if (cobranca.getNumero() == numeroCobranca) {
                cobranca.atualizarHorasTrabalhadas(data, horas);
                break;
            }
        }
    }
    
    public void enviar() {
        if (enviado) {
            System.out.println("O cartão de ponto já foi enviado e não pode ser alterado.");
            return;
        }
        double totalHorasTrabalhadas = 0;
        for (Cobranca cobranca : cobrancas) {
            totalHorasTrabalhadas += cobranca.getTotalHorasTrabalhadas();
        }

        // Validar se o total de horas trabalhadas excede o limite permitido para o funcionário
        if (totalHorasTrabalhadas > this.getLimiteHoras()) {
            System.out.println("O total de horas trabalhadas excede o limite permitido para o funcionário.");
            return;
        }
        enviado = true;
        System.out.println("Cartão de ponto enviado com sucesso.");
    }
    
}
