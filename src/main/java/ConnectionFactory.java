import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String url = "jdbc:mysql://localhost:33061/person";
    private final String user = "root";
    private final String password = "root";

    public Connection getConnection(){
        try {
            System.out.println("Conectando ao bd");
            Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexao esabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
