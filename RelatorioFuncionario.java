import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionario {

    private Scanner scanner = new Scanner(System.in);

    public void executar() {
        System.out.println("Selecione o tipo de relatório: ");
        System.out.println("1. Total de Horas Trabalhadas");
        System.out.println("2. Total de Horas Trabalhadas para um Projeto");
        System.out.println("3. Férias/Doença Licença");
        System.out.println("4. Pagamento Total Acumulado no Ano");

        int tipoRelatorio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a data de início do relatório (dd/MM/yyyy): ");
        Date dataInicio = lerData();

        System.out.println("Digite a data de término do relatório (dd/MM/yyyy): ");
        Date dataFim = lerData();

        switch (tipoRelatorio) {
            case 1:
                gerarRelatorioTotalHorasTrabalhadas(dataInicio, dataFim);
                break;
            case 2:
                gerarRelatorioTotalHorasProjeto(dataInicio, dataFim);
                break;
            case 3:
                gerarRelatorioFeriasDoenca(dataInicio, dataFim);
                break;
            case 4:
                gerarRelatorioPagamentoTotalAno(dataInicio, dataFim);
                break;
            default:
                System.out.println("Tipo de relatório inválido.");
        }
    }

    private void gerarRelatorioTotalHorasTrabalhadas(Date dataInicio, Date dataFim) {
        // Lógica para gerar relatório de total de horas trabalhadas
        System.out.println("Relatório de Total de Horas Trabalhadas gerado.");
        salvarRelatorio();
    }

    private void gerarRelatorioTotalHorasProjeto(Date dataInicio, Date dataFim) {
        // Lógica para gerar relatório de total de horas trabalhadas para um projeto
        List<String> numerosCobranca = recuperarNumerosCobranca();
        System.out.println("Selecione o número de cobrança:");
        for (int i = 0; i < numerosCobranca.size(); i++) {
            System.out.println((i + 1) + ". " + numerosCobranca.get(i));
        }
        int selecao = scanner.nextInt();
        scanner.nextLine();
        if (selecao < 1 || selecao > numerosCobranca.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
        String numeroCobranca = numerosCobranca.get(selecao - 1);
        System.out.println("Relatório de Total de Horas Trabalhadas para o Projeto " + numeroCobranca + " gerado.");
        salvarRelatorio();
    }

    private void gerarRelatorioFeriasDoenca(Date dataInicio, Date dataFim) {
        // Lógica para gerar relatório de férias/doença licença
        System.out.println("Relatório de Férias/Doença Licença gerado.");
        salvarRelatorio();
    }

    private void gerarRelatorioPagamentoTotalAno(Date dataInicio, Date dataFim) {
        // Lógica para gerar relatório de pagamento total acumulado no ano
        System.out.println("Relatório de Pagamento Total Acumulado no Ano"
    }
    
}