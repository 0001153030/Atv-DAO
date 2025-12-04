import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Classe DAO para a entidade Aluno, implementando operações CRUD. */
class AlunoDAO {

    /** Insere um novo aluno no banco de dados. */
    public void inserir(Aluno aluno) {
        // Verifica se o professor está logado.
        if (!ProfessorSession.isLoggedIn()) {
            System.out.println(
                "Ação não permitida. Faça login para cadastrar alunos."
            );
            return;
        }

        // Query SQL com placeholders para segurança.
        String sql = "INSERT INTO alunos (nome, email) VALUES (?, ?)";

        // try-with-resources para fechamento automático de recursos.
        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Mapeia o objeto Aluno para a Query SQL.
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());

            // Executa a instrução SQL.
            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    /** Lista todos os alunos do banco de dados. */
    public List<Aluno> listar() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Retorna o ResultSet com os dados.
            ResultSet rs = stmt.executeQuery()
        ) {
            // Itera sobre os resultados.
            while (rs.next()) {
                // Converte a linha do banco em um objeto Aluno.
                Aluno a = new Aluno(
                    rs.getInt("id"), // Pega o valor da coluna 'id'
                    rs.getString("nome"), // Pega o valor da coluna 'nome'
                    rs.getString("email") // Pega o valor da coluna 'email'
                );
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    /** Atualiza os dados de um aluno existente pelo ID. */
    public void atualizar(Aluno aluno) {
        // WHERE id = ? garante a atualização do registro correto.
        String sql = "UPDATE alunos SET nome = ?, email = ? WHERE id = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Define os novos valores.
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());

            // Define o ID do registro a ser atualizado.
            stmt.setInt(3, aluno.getId());

            stmt.executeUpdate();

            System.out.println("Aluno atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /** Remove um registro do banco de dados pelo ID. */
    public void deletar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?"; // Query para exclusão.

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Define o ID do aluno para exclusão.
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Aluno deletado!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
