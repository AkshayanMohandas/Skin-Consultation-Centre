import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    protected static ArrayList<Doctor> doctorArray = new ArrayList<Doctor>();
    private Scanner input = new Scanner(System.in);


    //method for adding doctor
    public void addDoctor() {
        if (doctorArray.size() <= 9) {
            System.out.println("Enter the Firstname of the Doctor: ");
            String doctorName = input.next().toUpperCase();
            System.out.println("Enter the Surname of the Doctor: ");
            String doctorSurname = input.next().toUpperCase();

            //Validation for Date of Birth
            boolean choice = true;
            String doctorDob = null;
            while (choice) {
                System.out.println("Enter the Date of Birth of the Doctor (YYYY-MM-DD): ");
                doctorDob = input.next();

                SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
                // df.setLenient(false);
                boolean valid = false;
                try {
                    df.parse(doctorDob);
                    valid = true;
                } catch (ParseException e) {
                } // valid will still be false
                if (!valid) {
                    System.out.println("Invalid Date Format");

                } else {
                    choice = false;
                }
            }

//            System.out.println("Enter the Date of Birth of the Doctor (YYYY-MM-DD): ");
//            String doctorDob = input.next().toUpperCase();

            boolean choice1 = false;
            String mobileNumber;
            int value1;
            do {
                System.out.println("Enter the Mobile Number of the Doctor: ");
                mobileNumber = input.next().toUpperCase();

                try {
                    value1 = Integer.parseInt(mobileNumber);
                    choice1 = true;
                } catch (NumberFormatException e) {
                    System.out.println("Integer expected, String entered");
                }
            }
            while (!choice1);
            value1 = Integer.parseInt(mobileNumber);


            //Validation for Medical licence number
            boolean choice2 = false;
            String licenseNumber = "";
            while (!choice2) {
                System.out.println("Enter the Medical licence number of the Doctor: ");
                licenseNumber = input.next().toUpperCase();
                choice2 = true;
                for (Doctor doctor : doctorArray) {
                    if (doctor.getLicenseNumber().toLowerCase().equals(licenseNumber.toLowerCase())) {
                        System.out.println("Duplicated Medical licence number! Enter a valid Medical licence number");
                        choice2 = false;
                    }
                }
            }

            System.out.println("Enter the Specialisation of the Doctor: ");
            String doctorSpecialisation = input.next().toUpperCase();

            Doctor doctor = new Doctor(doctorName, doctorSurname, doctorDob, mobileNumber, licenseNumber, doctorSpecialisation);
            doctorArray.add(doctor);
            System.out.println("The doctor has been added to the system successfully");
        } else {
            System.out.println("10 doctors are already registered with the system");
            System.out.println("You should delete a doctor from the system if you wish to add more doctors");
            System.out.println(" ");
        }


    }

    //method to delete doctor
    public void deleteDoctor() {
        System.out.println("Enter the license number of the doctor to delete from the system");
        String selectedLicense = input.next().toUpperCase();
        //print list
        for (Doctor doctor : doctorArray) {
            if (doctor.getLicenseNumber().toLowerCase().equals(selectedLicense.toLowerCase())) {
                System.out.println("Do you want to delete: " + doctor.getName());
                System.out.println("Enter yes/no");
                String option = input.next();

                if (option.toLowerCase().equals("yes")) {
                    doctorArray.remove(doctor);

                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println(doctor.getName() + " " + doctor.getSurname() + " " + doctor.getDOB() + " " + doctor.getNumber() + " " + doctor.getLicenseNumber() + " " + doctor.getSpecialisation());
                    System.out.println("Successfully deleted");
                    //sortDrivers();
                    System.out.println("The number of doctors right now in the system are :" + doctorArray.size());
                }
                return;
            }
        }
        System.out.println(selectedLicense + " is not in the system ");
    }


    //method for viewing all Doctors
    public void printDoctor() {
        sortDoctor();
        for (Doctor doctor : doctorArray) {
            System.out.println(doctor.getName() + "\t" +
                    doctor.getSurname() + "\t" +
                    doctor.getDOB() + "\t" +
                    doctor.getNumber() + "\t" +
                    doctor.getLicenseNumber() + "\t" +
                    doctor.getSpecialisation());
        }


    }

    //method to sort doctor in alphabetical order
    public static void sortDoctor() {
        Collections.sort(doctorArray, new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareTo(d2.getSurname());
            }
        });
    }


    //method to load data from a file
    public void loadFile() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("DoctorDetails.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);
        for (; ; ) {
            try {
                Doctor doctor = (Doctor) oi.readObject();
                doctorArray.add(doctor);
            } catch (EOFException e) {
                break;

            }
        }
        fi.close();
        oi.close();

        System.out.println("---------------------------------------------------------");
        System.out.println(" Doctors Loaded Successfully");
        sortDoctor();
    }

    //method to load GUI
    public ActionEvent loadGUI() throws IOException {
        new DoctorDetailsGUI();
        return null;
    }

    //method to store data to a file
    public void saveFile() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("DoctorDetails.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        for (Doctor doctor : doctorArray) {
            o.writeObject(doctor);
        }

        o.flush();
        f.close();
        o.close();
        System.out.println("The file has been successfully saved!!..");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner s = new Scanner(System.in);
        String input;
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

        try {// load previous file if available
            manager.loadFile();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");

        }

        do {
            System.out.println("||======================================================||");
            System.out.println("||            Westminster Skin Consultation             ||");
            System.out.println("||======================================================||");
            System.out.println("||  -To Add a new doctor enter                  'A'     ||");
            System.out.println("||  -To Delete a doctor enter                   'D'     ||");
            System.out.println("||  -To Print the list of the doctors enter     'P'     ||");
            System.out.println("||  -To Store data to a file enter              'S'     ||");
            System.out.println("||  -To Open GUI enter                          'G'     ||");
            System.out.println("||  -To Exit program enter                      'E'     ||");
            System.out.println("||======================================================||");
            System.out.print("Enter your selection : "); //gets the user input
            input = s.next().toUpperCase();
            switch (input) {
                case ("A"):
                    manager.addDoctor();    //The Method add is called
                    break;
                case ("D"):
                    manager.deleteDoctor(); //The Method delete is called
                    break;
                case ("P"):
                    manager.printDoctor();  //The Method print is called
                    break;
                case ("S"):
                    manager.saveFile();     //The Method save is called
                    break;
                case ("G"):
                    manager.loadGUI();      //The Method gui is called
                    break;
                case ("E"):
                    System.out.println("Program Ending");
                    System.exit(0);      //Terminates the program
                    break;
            }
        } while (!input.equals("E"));

    }

}
