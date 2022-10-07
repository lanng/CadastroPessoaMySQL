import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Person> listPersons(){
        String sql = "select * from persons";
        ArrayList<Person> persons = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setCpf(rs.getString("cpf"));
                person.setRg(rs.getString("rg"));
                person.setDateOfBirth(rs.getString("date"));
                person.setAddress(rs.getString("address"));
                person.setNationality(rs.getString("nationality"));
                persons.add(person);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    public void deletePerson(int id){
        String sql = "delete from persons where id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePerson(Person person){
        String sql = "update persons set name = ?, cpf = ?, rg = ?, date = ?, address = ?, nationality = ? where id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            statement.setString(3, person.getRg());
            statement.setString(4, person.getDateOfBirth());
            statement.setString(5, person.getAddress());
            statement.setString(6, person.getNationality());
            statement.setInt(7, person.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
