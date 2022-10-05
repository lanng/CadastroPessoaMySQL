public class Person {
    private int id;
    private String Name;
    private String Cpf;
    private String Rg;
    private String DateOfBirth;
    private String Address;
    private String Nationality;

    public Person(String name, String cpf, String rg, String dateOfBirth, String address, String nationality) {
        Name = name;
        Cpf = cpf;
        Rg = rg;
        DateOfBirth = dateOfBirth;
        Address = address;
        Nationality = nationality;
    }

    public Person(){
        //Empty constructor
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getData(){
        String str = "";
        str += "| " + id + "|" + Name + "|" + Cpf + "|" + Rg + "|" + DateOfBirth + "|" + Address + "|" + Nationality;
        return  str;
    }
}
