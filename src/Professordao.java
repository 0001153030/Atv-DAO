package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Acesso a Dados (DAO) para a entidade Professor.
 * Implementa todas as operações CRUD (Create, Read, Update, Delete).
 */
class ProfessorDAO {

    /**
     * CREATE: Insere um novo professor no BD.
     */
    public void inserir(Professor professor) {
        // Query SQL usa '?' (placeholders) para segurança (PreparedStatement).
        String sql =
            "INSERT INTO professores (nome, rua, bairro, cidade, estado_civil, estado, salario, email, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources: Garante o fechamento automático da Conexão e do PreparedStatement.
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
            stmt.executeUpdate();

            System.out.println("Professor inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    /**
     * READ ALL: Lista todos os professores do BD.
     * @return Lista de objetos Professor.
     */
    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professores";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            // executeQuery() retorna o ResultSet (conjunto de resultados).
            ResultSet rs = stmt.executeQuery()
        ) {
            // Itera sobre cada linha retornada pelo banco de dados.
            while (rs.next()) {
                // Mapeamento reverso: Converte a linha do BD em um objeto Professor.
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

    /**
     * UPDATE: Atualiza os dados de um professor existente pelo ID.
     */
    public void atualizar(Professor professor) {
        // A cláusula WHERE id = ? é essencial para garantir a atualização do registro correto.
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

    /**
     * DELETE: Remove um registro do BD com base no ID.
     */
    public void deletar(int id) {
        String sql = "DELETE FROM professores WHERE id = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Define o ID do professor a ser deletado.
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Professor deletado!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
