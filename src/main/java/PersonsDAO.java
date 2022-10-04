import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonsDAO {
    private Connection conn;

    public PersonsDAO() {
        conn = new ConnectionFactory().getConnection();
    }

    public void addPerson(Person person){
        String sql = "insert into persons(name, cpf, rg, date, address, nationality) values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            statement.setString(3, person.getRg());
            statement.setString(4, person.getDateOfBirth());
            statement.setString(5, person.getAddress());
            statement.setString(6, person.getNationality());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
