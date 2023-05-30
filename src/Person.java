import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surname;
    private String dob;
    private String mobileNumber;

    public Person(String name, String surname, String dob, String mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public String getDOB() {
        return dob;
    }

    public void setNumber(String mobile_number) {
        this.mobileNumber = mobileNumber;
    }

    public String getNumber() {
        return mobileNumber;
    }


    public String toString() {
        return " Name=" + name +
                "Surname=" + surname +
                "DOB=" + dob +
                "Mobile Number=" + mobileNumber
                ;

    }
}
