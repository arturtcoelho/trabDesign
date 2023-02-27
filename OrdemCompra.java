public import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrdemCompra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<OrdemCompra> ordensCompra = new ArrayList<>();

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar uma ordem de compra");
            System.out.println("2. Atualizar uma ordem de compra");
            System.out.println("3. Excluir uma ordem de compra");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    OrdemCompra novaOrdemCompra = criarOrdemCompra(scanner);
                    ordensCompra.add(novaOrdemCompra);
                    System.out.println("Ordem de compra criada com sucesso!");
                    System.out.println("ID da ordem de compra: " + novaOrdemCompra.getId());
                    break;
                case 2:
                    atualizarOrdemCompra(scanner, ordensCompra);
                    break;
                case 3:
                    excluirOrdemCompra(scanner, ordensCompra);
                    break;
                default:
                    System.out.println("Opção inválida, selecione novamente.");
            }
        }
    }

    private static OrdemCompra criarOrdemCompra(Scanner scanner) {
        System.out.println("Digite o ponto de contato do cliente:");
        String pontoContato = scanner.nextLine();
        System.out.println("Digite o endereço de cobrança do cliente:");
        String enderecoCobranca = scanner.nextLine();
        System.out.println("Digite o produto(s) adquirido(s):");
        String produto = scanner.nextLine();
        Date data = new Date();
        OrdemCompra novaOrdemCompra = new OrdemCompra(pontoContato, enderecoCobranca, produto, data);
        return novaOrdemCompra;
    }

    private static void atualizarOrdemCompra(Scanner scanner, List<OrdemCompra> ordensCompra) {
        System.out.println("Digite o ID da ordem de compra:");
        int id = scanner.nextInt();
        scanner.nextLine();
        OrdemCompra ordemCompra = buscarOrdemCompra(id, ordensCompra);
        if (ordemCompra == null) {
            System.out.println("Ordem de compra não encontrada.");
        } else {
            System.out.println(ordemCompra);
            System.out.println("Digite o ponto de contato do cliente (ou pressione Enter para manter o valor atual):");
            String pontoContato = scanner.nextLine();
            if (!pontoContato.isEmpty()) {
                ordemCompra.setPontoContato(pontoContato);
            }
            System.out.println("Digite o endereço de cobrança do cliente (ou pressione Enter para manter o valor atual):");
            String enderecoCobranca = scanner.nextLine();
            if (!enderecoCobranca.isEmpty()) {
                ordemCompra.setEnderecoCobranca(enderecoCobranca);
            }
            System.out.println("Digite o produto(s) adquirido(s) (ou pressione Enter para manter o valor atual):");
            String produto = scanner.nextLine();
            if (!produto.isEmpty()) {
                ordemCompra.setProduto(produto);
            }
            System.out.println("Ordem de compra atualizada com sucesso!");
        }
    } 

    public void excluirOrdemCompra(Scanner scanner, List<OrdemCompra> ordensCompra) {
        Scanner scanner = new Scanner(System.in);

        // Passo 1: solicita que o Funcionário Comissionado especifique o id da ordem de Compra
        System.out.print("Insira o ID da ordem de compra: ");
        int idOrdemCompra = scanner.nextInt();

        // Passo 2: recupera o pedido de compra associado ao ID da ordem de Compra
        OrdemCompra ordemCompra = buscarOrdemCompra(idOrdemCompra, ordensCompra);

        // Passo 3: verifica se a ordem de Compra é uma ordem de Compra para o Funcionário Comissionado e se a ordem de Compra está aberta
        if (ordemCompra == null) {
            System.out.println("Ordem de compra não encontrada.");
            return;
        }
        if (!ordemCompra.getFuncionario().equals(funcionario)) {
            System.out.println("Você não tem permissão para excluir essa ordem de compra.");
            return;
        }
        if (!ordemCompra.isAberta()) {
            System.out.println("Essa ordem de compra já foi concluída e não pode ser excluída.");
            return;
        }

        // Passo 5: exibe a ordem de Compra
        System.out.println("Ordem de compra encontrada:");
        System.out.println(ordemCompra);

        // Passo 6: solicita ao Funcionário Comissionado que confirme a exclusão da ordem de Compra
        System.out.print("Digite 'S' para confirmar a exclusão: ");
        String confirmacao = scanner.next();

        // Passo 7: o Funcionário Comissionado verifica a exclusão
        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        // Passo 8: remove a ordem de Compra do sistema
        ordensCompra.remove(ordemCompra);
        System.out.println("Ordem de compra excluída com sucesso.");
    }

    public static OrdemCompra buscarOrdemCompra(int id, List<OrdemCompra> ordensCompra) {
        for (OrdemCompra ordem : ordensCompra) {
            if (ordem.getId() == id) {
                return ordem;
            }
        }
        return null; // retorna null caso não encontre a ordem de compra
    }
}
