import java.time.LocalDate;

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