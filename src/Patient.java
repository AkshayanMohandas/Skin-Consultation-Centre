public class Patient extends Person {

    private String title;
    private String id;
    private String mail;
    private String city;


    public Patient(String name, String surname, String dob, String mobile_number) {
        super(name, surname, dob, mobile_number);
        this.title = title;
        this.id = id;
        this.mail = mail;
        this.city = city;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return super.toString() +
                "Title = " + title +
                "ID = " + id +
                "Mail = " + mail +
                "City " + city;

    }
}
