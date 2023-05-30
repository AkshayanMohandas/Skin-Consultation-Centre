public class ConsulationDetails {
    private String name;
    private String surName;
    private String dob;
    private String mobileNo;
    private String id;
    private String duration;
    private String notes;
    private String doctorName;
    private String consultDate;
    private String consultTime;
    private String imageURL;

    public ConsulationDetails(String name, String surName, String dob, String mobileNo, String id, String duration, String notes, String doctorName, String consultDate, String consultTime, String imageURL) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.id = id;
        this.duration = duration;
        this.notes = notes;
        this.doctorName = doctorName;
        this.consultDate = consultDate;
        this.consultTime = consultTime;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
        this.consultDate = consultDate;
    }

    public String getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(String consultTime) {
        this.consultTime = consultTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
