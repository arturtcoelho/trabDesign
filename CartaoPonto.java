import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartaoPonto {
    
    private LocalDate inicioPeriodo;
    private LocalDate fimPeriodo;
    private boolean enviado;
    private List<Cobranca> cobrancas;
    
    public CartaoPonto(LocalDate inicioPeriodo, LocalDate fimPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
        this.fimPeriodo = fimPeriodo;
        this.enviado = false;
        this.cobrancas = new ArrayList<>();
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
        if (totalHorasTrabalhadas > Funcionario.getLimiteHorasTrabalhadas()) {
            System.out.println("O total de horas trabalhadas excede o limite permitido para o funcionário.");
            return;
        }
        enviado = true;
        System.out.println("Cartão de ponto enviado com sucesso.");
    }
    
}

public class Cobranca {
    
    private int numero;
    private double[] horasTrabalhadas;
    
    public Cobranca(int numero, int numeroDias) {
        this.numero = numero;
        this.horasTrabalhadas = new double[numeroDias];
    }
    
    public int getNumero() {
        return numero;
    }
    
    public double[] getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    
    public void atualizarHorasTrabalhadas(LocalDate data, double horas) {
        int index = data.getDayOfMonth() - 1;
        if (horas > 24 || horas < 0) {
            System.out.println("Número de horas inválido.");
            return;
        }
        horasTrabalhadas[index] = horas;
    }
    
    public double getTotalHorasTrabalhadas() {
        double total = 0;
        for (double horas : horasTrabalhadas) {
            total += horas;
        }
        return total;
    }
    
}