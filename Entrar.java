import java.util.Scanner;

public class Entrar {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;
        boolean loginValido = false;
        
        System.out.println("Bem-vindo ao Sistema de Folha de Pagamento!");
        
        while (!loginValido) {
            System.out.print("Nome de usuário: ");
            nomeUsuario = scanner.nextLine();
            
            System.out.print("Senha: ");
            senha = scanner.nextLine();
            
            if (verificarCredenciais(nomeUsuario, senha)) {
                System.out.println("Login realizado com sucesso!");
                loginValido = true;
            } else {
                System.out.println("Nome de usuário ou senha inválidos. Tente novamente.");
            }
        }
        
        // código a ser executado após o login ser realizado com sucesso
        
    }
    
    private static boolean verificarCredenciais(String nomeUsuario, String senha) {
        // lógica para verificar se as credenciais estão corretas
        // retorna true se as informações fornecidas pelo usuário estiverem corretas
        // retorna false caso contrário
        return true; // exemplo: sempre retorna true
    }
    
}