public class Person {
    public String nama;
    public String username;
    public String password;

    public Person(String nama, String username, String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }
}
