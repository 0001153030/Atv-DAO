package src;

import java.util.Scanner;

/**
 * Classe Principal de Execução.
 * Simula a interface do usuário e testa as operações CRUD chamando o AlunoDAO.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instancia os objetos DAO para Aluno e Professor.
        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Operações com Aluno");
        System.out.println("2 - Operações com Professor");
        int escolha = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do Scanner após escolha.

        if (escolha == 1) {
            System.out.println("=== CADASTRO DE ALUNO ===");

            // --- 1. Operação CREATE (Criação) ---
            System.out.print("Digite o nome do aluno: ");
            String nome = sc.nextLine();

            System.out.print("Digite o email do aluno: ");
            String email = sc.nextLine();

            // Cria o objeto POO (sem ID, que será gerado pelo BD).
            Aluno novo = new Aluno(nome, email);
            // Chama o método DAO para persistir o objeto.
            alunoDAO.inserir(novo);

            // --- 2. Operação READ (Leitura/Listagem) ---
            System.out.println("\n--- LISTA DE ALUNOS ---");
            for (Aluno a : alunoDAO.listar()) {
                System.out.println(
                    a.getId() + " - " + a.getNome() + " - " + a.getEmail()
                );
            }

            // --- 3. Operação UPDATE (Atualização) ---
            System.out.println("\n=== ATUALIZAR UM ALUNO ===");
            System.out.print("Digite o ID do aluno que deseja atualizar: ");
            int idAtualizar = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do Scanner após leitura de ID.

            System.out.print("Novo nome: ");
            String novoNome = sc.nextLine();

            System.out.print("Novo email: ");
            String novoEmail = sc.nextLine();

            Aluno atualizado = new Aluno(idAtualizar, novoNome, novoEmail);
            alunoDAO.atualizar(atualizado);

            // --- 4. Operação DELETE (Exclusão) ---
            System.out.println("\n=== DELETAR UM ALUNO ===");
            System.out.print("Digite o ID do aluno que deseja deletar: ");
            int idDelete = sc.nextInt();
            alunoDAO.deletar(idDelete);
        } else if (escolha == 2) {
            System.out.println("=== CADASTRO DE PROFESSOR ===");

            // --- 1. Operação CREATE (Criação) ---
            System.out.print("Digite o nome do professor: ");
            String nome = sc.nextLine();

            System.out.print("Digite a rua: ");
            String rua = sc.nextLine();

            System.out.print("Digite o número: ");
            int numero = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do Scanner após leitura de número.

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

            System.out.print("Digite o email: ");
            String email = sc.nextLine();
            sc.nextLine();

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
            professorDAO.inserir(novo);

            // --- 2. Operação READ (Leitura/Listagem) ---
            System.out.println("\n--- LISTA DE PROFESSORES ---");
            for (Professor p : professorDAO.listar()) {
                System.out.println(
                    p.getId() +
                        " - " +
                        p.getNome() +
                        " - " +
                        p.getRua() +
                        " - " +
                        p.getBairro() +
                        " - " +
                        p.getCidade() +
                        " - " +
                        p.getEstadoCivil() +
                        " - " +
                        p.getEstado() +
                        " - " +
                        p.getSalario() +
                        " - " +
                        p.getEmail() +
                        " - " +
                        p.getNumero()
                );
            }

            // --- 3. Operação UPDATE (Atualização) ---
            System.out.println("\n=== ATUALIZAR UM PROFESSOR ===");
            System.out.print("Digite o ID do professor que deseja atualizar: ");
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
            sc.nextLine(); // Limpa o buffer do Scanner após leitura de salário.

            System.out.print("Novo email: ");
            String novoEmail = sc.nextLine();

            System.out.print("Novo número: ");
            int novoNumero = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do Scanner após leitura de número.

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

            // --- 4. Operação DELETE (Exclusão) ---
            System.out.println("\n=== DELETAR UM PROFESSOR ===");
            System.out.print("Digite o ID do professor que deseja deletar: ");
            int idDelete = sc.nextInt();
            professorDAO.deletar(idDelete);
        } else {
            System.out.println("Opção inválida!");
        }

        sc.close();
    }
}
