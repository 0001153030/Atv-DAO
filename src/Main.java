import java.util.Scanner;

/**
 * Classe Principal de Execução.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

        boolean continuar = true;
        boolean isLoggedIn = false; // Tracks login status
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Operações com Aluno");
            System.out.println("2 - Operações com Professor");
            System.out.println("3 - Login como Professor");
            int escolha = sc.nextInt();
            sc.nextLine(); // Clear buffer after numeric input

            if (escolha == 1) {
                if (!isLoggedIn) {
                    System.out.println("Acesso negado. Faça login primeiro.");
                    continue;
                }
                System.out.println("=== OPERAÇÕES COM ALUNO ===");
                System.out.println("1 - Cadastrar Aluno");
                System.out.println("2 - Atualizar Aluno");
                System.out.println("3 - Deletar Aluno");
                System.out.print("Escolha uma operação: ");
                int operacaoAluno = sc.nextInt();
                sc.nextLine();

                if (operacaoAluno == 1) {
                    System.out.println("=== CADASTRO DE ALUNO ===");
                    System.out.print("Digite o nome do aluno: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o email do aluno: ");
                    String email = sc.nextLine();

                    Aluno novo = new Aluno(nome, email);
                    alunoDAO.inserir(novo);
                } else if (operacaoAluno == 2) {
                    System.out.println("\n=== ATUALIZAR UM ALUNO ===");
                    System.out.print(
                        "Digite o ID do aluno que deseja atualizar: "
                    );
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    Aluno atualizado = new Aluno(
                        idAtualizar,
                        novoNome,
                        novoEmail
                    );
                    alunoDAO.atualizar(atualizado);
                } else if (operacaoAluno == 3) {
                    System.out.println("\n=== DELETAR UM ALUNO ===");
                    System.out.print(
                        "Digite o ID do aluno que deseja deletar: "
                    );
                    int idDelete = sc.nextInt();
                    alunoDAO.deletar(idDelete);
                } else {
                    System.out.println("Operação inválida!");
                }
            } else if (escolha == 2) {
                System.out.println("=== OPERAÇÕES COM PROFESSOR ===");
                System.out.println("1 - Cadastrar Professor");
                System.out.println("2 - Atualizar Professor");
                System.out.println("3 - Deletar Professor");
                System.out.print("Escolha uma operação: ");
                int operacaoProfessor = sc.nextInt();
                sc.nextLine();

                if (operacaoProfessor == 1) {
                    System.out.println("=== CADASTRO DE PROFESSOR ===");
                    System.out.print("Digite o nome do professor: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a rua: ");
                    String rua = sc.nextLine();

                    System.out.print("Digite o número: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o bairro: ");
                    String bairro = sc.nextLine();

                    System.out.print("Digite a cidade: ");
                    String cidade = sc.nextLine();

                    System.out.print("Digite o estado civil: ");
                    String estadoCivil = sc.nextLine();

                    System.out.print("Digite o estado: ");
                    String estado = sc.nextLine();

                    System.out.print("Digite o salário: ");
                    double salario = sc.nextDouble();

                    sc.nextLine(); // Clear buffer
                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();

                    Professor novo = new Professor(
                        nome,
                        rua,
                        bairro,
                        cidade,
                        estadoCivil,
                        estado,
                        salario,
                        email,
                        numero
                    );
                    novo.setSenha(senha);
                    professorDAO.inserir(novo);
                } else if (operacaoProfessor == 2) {
                    System.out.println("\n=== ATUALIZAR UM PROFESSOR ===");
                    System.out.print(
                        "Digite o ID do professor que deseja atualizar: "
                    );
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Nova rua: ");
                    String novaRua = sc.nextLine();

                    System.out.print("Novo bairro: ");
                    String novoBairro = sc.nextLine();

                    System.out.print("Nova cidade: ");
                    String novaCidade = sc.nextLine();

                    System.out.print("Novo estado civil: ");
                    String novoEstadoCivil = sc.nextLine();

                    System.out.print("Novo estado: ");
                    String novoEstado = sc.nextLine();

                    System.out.print("Novo salário: ");
                    double novoSalario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    System.out.print("Novo número: ");
                    int novoNumero = sc.nextInt();
                    sc.nextLine();

                    Professor atualizado = new Professor(
                        idAtualizar,
                        novoNome,
                        novaRua,
                        novoBairro,
                        novaCidade,
                        novoEstadoCivil,
                        novoEstado,
                        novoSalario,
                        novoEmail,
                        novoNumero
                    );
                    professorDAO.atualizar(atualizado);
                } else if (operacaoProfessor == 3) {
                    System.out.println("\n=== DELETAR UM PROFESSOR ===");
                    System.out.print(
                        "Digite o ID do professor que deseja deletar: "
                    );
                    int idDelete = sc.nextInt();
                    professorDAO.deletar(idDelete);
                } else {
                    System.out.println("Operação inválida!");
                }
            } else if (escolha == 3) {
                System.out.println("=== LOGIN COMO PROFESSOR ===");
                System.out.print("Digite o email: ");
                String email = sc.nextLine(); // Ensure proper input handling

                System.out.print("Digite a senha: ");
                String senha = sc.nextLine(); // Read password input

                if (professorDAO.autenticar(email, senha)) {
                    System.out.println(
                        "Login bem-sucedido! Bem-vindo, Professor."
                    );
                    isLoggedIn = true; // Set login status to true
                } else {
                    System.out.println(
                        "Falha no login. Verifique suas credenciais."
                    );
                    isLoggedIn = false; // Ensure login status remains false
                }
            } else {
                System.out.println("Opção inválida!");
            }

            System.out.print("Deseja voltar ao menu principal? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();
            if (!resposta.equals("s")) {
                continuar = false;
            }
        }

        sc.close();
    }
}
