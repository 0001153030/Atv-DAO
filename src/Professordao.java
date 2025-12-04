import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** DAO para a entidade Professor, com operações CRUD e autenticação. */
class ProfessorDAO {

    /** Autentica um professor pelo email e senha. */
    public boolean autenticar(String email, String senha) {
        String sql = "SELECT * FROM professores WHERE email = ? AND senha = ?";
        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Se as credenciais forem válidas, define a sessão
                ProfessorSession.setLoggedIn(true);
                ProfessorSession.setProfessorId(rs.getInt("id"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }
        return false;
    }

    /** Insere um novo professor no BD. */
    public void inserir(Professor professor) {
        // Query SQL com placeholders para segurança.
        String sql =
            "INSERT INTO professores (nome, rua, bairro, cidade, estado_civil, estado, salario, email, numero, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources para fechamento automático.
        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Mapeamento do objeto Professor para a Query SQL.
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getRua());
            stmt.setString(3, professor.getBairro());
            stmt.setString(4, professor.getCidade());
            stmt.setString(5, professor.getEstadoCivil());
            stmt.setString(6, professor.getEstado());
            stmt.setDouble(7, professor.getSalario());
            stmt.setString(8, professor.getEmail());
            stmt.setInt(9, professor.getNumero());

            // Executa a instrução SQL de modificação (INSERT).
            stmt.setString(10, professor.getSenha());
            stmt.executeUpdate();

            System.out.println("Professor inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    /** Lista todos os professores do BD. */
    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professores";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            // executeQuery retorna o ResultSet.
            ResultSet rs = stmt.executeQuery()
        ) {
            // Itera sobre cada linha retornada pelo banco de dados.
            while (rs.next()) {
                // Converte a linha do BD em um objeto Professor.
                Professor p = new Professor(
                    rs.getInt("id"), // Pega o valor da coluna 'id'
                    rs.getString("nome"), // Pega o valor da coluna 'nome'
                    rs.getString("rua"), // Pega o valor da coluna 'rua'
                    rs.getString("bairro"), // Pega o valor da coluna 'bairro'
                    rs.getString("cidade"), // Pega o valor da coluna 'cidade'
                    rs.getString("estado_civil"), // Pega o valor da coluna 'estado_civil'
                    rs.getString("estado"), // Pega o valor da coluna 'estado'
                    rs.getDouble("salario"), // Pega o valor da coluna 'salario'
                    rs.getString("email"), // Pega o valor da coluna 'email'
                    rs.getInt("numero") // Pega o valor da coluna 'numero'
                );
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    /** Atualiza os dados de um professor pelo ID. */
    public void atualizar(Professor professor) {
        // Cláusula WHERE id = ? para atualizar o registro correto.
        String sql =
            "UPDATE professores SET nome = ?, rua = ?, bairro = ?, cidade = ?, estado_civil = ?, estado = ?, salario = ?, email = ?, numero = ? WHERE id = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Novos valores para os atributos do Professor.
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getRua());
            stmt.setString(3, professor.getBairro());
            stmt.setString(4, professor.getCidade());
            stmt.setString(5, professor.getEstadoCivil());
            stmt.setString(6, professor.getEstado());
            stmt.setDouble(7, professor.getSalario());
            stmt.setString(8, professor.getEmail());
            stmt.setInt(9, professor.getNumero());

            // ID do registro a ser atualizado (condição WHERE).
            stmt.setInt(10, professor.getId());

            stmt.executeUpdate();

            System.out.println("Professor atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /** Remove um registro do BD pelo ID. */
    public void deletar(int id) {
        String sql = "DELETE FROM professores WHERE id = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Define o ID do professor para exclusão.
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Professor deletado!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
