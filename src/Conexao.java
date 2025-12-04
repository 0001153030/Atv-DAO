import java.sql.Connection;
import java.sql.DriverManager;

/** Classe para Gerenciamento de Conexão JDBC. */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/escola";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /** Estabelece a conexão com o banco de dados. */
    public static Connection getConnection() {
        try {
            // Estabelece a conexão usando as credenciais.
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            // Lança uma exceção em caso de falha.
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}
