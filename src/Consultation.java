import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Consultation extends Person {

    private String date;
    private String time;
    private int cost;
    private String notes;

    public Consultation(String name, String surname, String dob, String mobileNumber, String date, String time, int cost, String notes) {
        super(name, surname, dob, mobileNumber);
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }

    public Consultation(String name, String surname, String dob, String mobileNumber) {
        super(name, surname, dob, mobileNumber);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}


