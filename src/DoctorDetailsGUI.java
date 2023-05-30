import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class DoctorDetailsGUI extends WestminsterSkinConsultationManager implements ActionListener, KeyListener {
    private static String doctorName;
    DefaultTableModel tableModel = new DefaultTableModel();


    private static ArrayList<String> personaldetailsList = new ArrayList<String>();
    public static ArrayList<ConsulationDetails> consulationDetails = new ArrayList<ConsulationDetails>();
    private static String[] choices = new String[10];


    private static JFrame frame1;
    private static JFrame frame2;
    private static JFrame frame3;
    private static JFrame frame4;
    private static JFrame frame5;
    private static JFrame warning;


    Color color1 = new Color(73, 2, 72);
    Color color2 = new Color(185, 228, 235);

    private static JButton viewDoctorButton = new JButton("View Doctors");
    private static JButton bookDoctorButton = new JButton("Book Doctor");
    private static JButton consultationDetailButton = new JButton("View All Consultation Details");
    private static JButton saveButton = new JButton("Save");
    private static JButton resetButton = new JButton("Reset");
    private static JButton viewButton = new JButton("View Details");
    private static JButton bookButton = new JButton("Book");
    private static JButton alphabeticalOrder = new JButton("Order Alphabetically");
    private static JButton exitButton = new JButton("Exit");

    private static JButton picButton = new JButton("Insert Picture");

    private static JLabel nameLabel = new JLabel("Name");
    private static JLabel surnameLabel = new JLabel("Surname");
    private static JLabel dobLabel = new JLabel("Date of Birth");
    private static JLabel mobileNOLabel = new JLabel("Mobile Number");
    private static JLabel idLabel = new JLabel("ID Number");
    private static JLabel durationLabel = new JLabel("Duration of Consultaion");
    private static JLabel firstConsultationLabel = new JLabel("First Consultation?");
    private static JLabel saveMessageLabel = new JLabel(" ");
    private static JLabel headingLabel = new JLabel("Book your Doctor");
    private static JLabel headingLabel1 = new JLabel("Personal Details");
    private static JLabel doctorNameLabel = new JLabel("Doctor's Name");
    private static JLabel dateLabel = new JLabel("Date of Consultation");
    private static JLabel timeLabel = new JLabel("Time of Consultation");
    private static JLabel infoOne = new JLabel("Choose the doctor you want to consult with");
    private static JLabel infotwo = new JLabel("Enter the date in 'dd/mm/yyyy' format");
    private static JLabel infothree = new JLabel("Enter the time in 'hh:mm' format");

    private static JLabel label2 = new JLabel();

    private static JTextField nameText = new JTextField();
    private static JTextField surnameText = new JTextField();
    private static JTextField dobText = new JTextField();
    private static JTextField mobileNoText = new JTextField();
    private static JTextField idText = new JTextField();
    private static JTextField durationText = new JTextField();
    private static JTextField notesText = new JTextField("Add Notes");
    private static JTextField dateText = new JTextField("dd/mm/yyyy");
    private static JTextField timeText = new JTextField("hh:mm");

    private static JComboBox<String> doctorOption = new JComboBox<String>();

    JTable table;
    JTable table1;

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();


    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    FileWriter fw = new FileWriter("Consultation.txt", true);


    public DoctorDetailsGUI() throws IOException {


        try {
            loadFileArray();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        frame1 = new JFrame();

        label2.setBounds(80, 40, 803, 474);
        frame1.add(label2);

        label2.setIcon(ResizeImage("consultation.png"));

        viewDoctorButton.setBounds(100, 580, 200, 40);
        viewDoctorButton.setFocusable(false);
        viewDoctorButton.addActionListener(this);

        bookDoctorButton.setBounds(400, 580, 200, 40);
        bookDoctorButton.setFocusable(false);
        bookDoctorButton.addActionListener(this);

        consultationDetailButton.setBounds(700, 580, 200, 40);
        consultationDetailButton.setFocusable(false);
        consultationDetailButton.addActionListener(this);


        frame1.add(viewDoctorButton);
        frame1.add(bookDoctorButton);
        frame1.add(consultationDetailButton);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1000, 700);
        frame1.setLayout(null);
        frame1.setVisible(true);

    }

    public void doctorDetails() {
        frame2 = new JFrame();
        frame2.setLayout(new GridLayout(2, 2));

        table = new JTable(tableModel);

        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("D.O.B");
        tableModel.addColumn("Mobile No.");
        tableModel.addColumn("License No");
        tableModel.addColumn("Specialisation");


        for (int i = 0; i < doctorArray.size(); i++) {
            tableModel.insertRow(i, new Object[]{doctorArray.get(i).getName(), doctorArray.get(i).getSurname(), doctorArray.get(i).getDOB(), doctorArray.get(i).getNumber(), doctorArray.get(i).getLicenseNumber(), doctorArray.get(i).getSpecialisation()});
        }
        table.setBounds(0, 0, 1000, 700);
        table.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(table);

        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel1.add(jScrollPane);


        panel1.setBounds(0, 0, 1000, 700);

        bookDoctorButton.setBounds(20, 500, 150, 35);
        alphabeticalOrder.setBounds(20, 700, 150, 35);
        panel4.add(bookDoctorButton);
        panel4.add(alphabeticalOrder);
        alphabeticalOrder.addActionListener(this);

        panel4.setBounds(0, 710, 1000, 290);

        frame2.add(panel1);
        frame2.add(panel4);


        frame2.setSize(1000, 700);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

    }

    public void conDetails() {
        frame5 = new JFrame();
        frame5.setLayout(new GridLayout(2, 2));

        Object[][] rows = new Object[consulationDetails.size()][11];
        for (int i = 0; i < consulationDetails.size(); i++) {
            rows[i][0] = consulationDetails.get(i).getName();
            rows[i][1] = consulationDetails.get(i).getSurName();
            rows[i][2] = consulationDetails.get(i).getDob();
            rows[i][3] = consulationDetails.get(i).getMobileNo();
            rows[i][4] = consulationDetails.get(i).getId();
            rows[i][5] = consulationDetails.get(i).getDuration();
            rows[i][6] = consulationDetails.get(i).getNotes();
            rows[i][7] = consulationDetails.get(i).getDoctorName();
            rows[i][8] = consulationDetails.get(i).getConsultDate();
            rows[i][9] = consulationDetails.get(i).getConsultTime();
            rows[i][10] = "View";

        }


        String[] columns = {"Name", "Surname", "D.O.B", "Mobile No.", "License No.", "Duration", "Note", "Doctor Name", "Consult Date", "Consult Time", "Button"};

        table1 = new JTable(rows, columns);
        table1.setBounds(0, 0, 400, 400);
        table1.setRowHeight(35);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(4).setPreferredWidth(100);
        table1.getColumnModel().getColumn(5).setPreferredWidth(100);
        table1.getColumnModel().getColumn(6).setPreferredWidth(100);
        table1.getColumnModel().getColumn(7).setPreferredWidth(100);
        table1.getColumnModel().getColumn(8).setPreferredWidth(100);
        table1.getColumnModel().getColumn(9).setPreferredWidth(100);
        table1.getColumnModel().getColumn(10).setPreferredWidth(200);
        table1.getColumn("Button").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
        JScrollPane jScrollPane = new JScrollPane(table1);
        jScrollPane.setBounds(0, 0, 300, 300);

        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel5.add(jScrollPane);

        panel5.setBounds(0, 0, 800, 700);
        frame5.add(panel5);

        frame5.setSize(1000, 700);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setVisible(true);

    }

    public void bookDoctor() {
        frame4 = new JFrame();
        panel2.setLayout(null);

        for (int i = 0; i < doctorArray.size(); i++) {
            String name = doctorArray.get(i).getName();
            choices[i] = name;
        }

        doctorOption = new JComboBox((String[]) choices);

        doctorOption.setBounds(470, 125, 250, 25);

        headingLabel.setBounds(433, 40, 150, 25);
        doctorNameLabel.setBounds(300, 125, 100, 25);
        dateLabel.setBounds(300, 225, 150, 25);
        timeLabel.setBounds(300, 325, 150, 25);
        infoOne.setBounds(470, 145, 250, 25);
        infotwo.setBounds(470, 245, 250, 25);
        infothree.setBounds(470, 345, 250, 25);

        dateText.setBounds(470, 225, 250, 25);
        timeText.setBounds(470, 325, 250, 25);

        bookButton.setBounds(425, 480, 150, 35);


        Consultation consultation = new Consultation("", "", "", "");

        consultation.setDate(String.valueOf(dateText));
        consultation.setTime(String.valueOf(timeText));


        panel2.add(headingLabel);
        panel2.add(doctorNameLabel);
        panel2.add(doctorOption);
        panel2.add(dateLabel);
        panel2.add(timeLabel);
        panel2.add(dateText);
        panel2.add(timeText);
        panel2.add(bookButton);
        panel2.add(infoOne);
        panel2.add(infotwo);
        panel2.add(infothree);


        bookButton.addActionListener(this);

        frame4.add(panel2);


        frame4.setSize(1000, 700);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);

    }


    public void personalDetails() {
        frame3 = new JFrame();
        panel3.setLayout(null);

        headingLabel1.setBounds(445, 10, 150, 25);
        nameLabel.setBounds(290, 50, 160, 25);
        surnameLabel.setBounds(290, 100, 160, 25);
        dobLabel.setBounds(290, 150, 160, 25);
        mobileNOLabel.setBounds(290, 200, 160, 25);
        idLabel.setBounds(290, 250, 160, 25);
        durationLabel.setBounds(290, 300, 160, 25);
        firstConsultationLabel.setBounds(290, 350, 160, 25);
        saveMessageLabel.setBounds(290, 400, 350, 50);

        nameText.setBounds(565, 50, 165, 25);
        nameText.addKeyListener(this);
        nameText.requestFocus();
        surnameText.setBounds(565, 100, 165, 25);
        surnameText.setEditable(false);
        surnameText.addKeyListener(this);
        dobText.setBounds(565, 150, 165, 25);
        dobText.setEditable(false);
        dobText.addKeyListener(this);
        mobileNoText.setBounds(565, 200, 165, 25);
        mobileNoText.setEditable(false);
        mobileNoText.addKeyListener(this);
        idText.setBounds(565, 250, 165, 25);
        idText.setEditable(false);
        idText.addKeyListener(this);
        durationText.setBounds(565, 300, 165, 25);
        durationText.setEditable(false);
        durationText.addKeyListener(this);
        notesText.setBounds(290, 350, 430, 75);
        notesText.setEditable(false);
        notesText.addKeyListener(this);

        picButton.setBounds(565, 450, 150, 25);


        saveButton.setBounds(290, 580, 150, 35);
        resetButton.setBounds(565, 580, 150, 35);
        viewButton.setBounds(100, 530, 150, 25);
        picButton.addActionListener(this);

        saveButton.addActionListener(this);
        resetButton.addActionListener(this);

        panel3.add(headingLabel1);
        panel3.add(nameLabel);
        panel3.add(nameText);
        panel3.add(surnameLabel);
        panel3.add(surnameText);
        panel3.add(dobLabel);
        panel3.add(dobText);
        panel3.add(mobileNOLabel);
        panel3.add(mobileNoText);
        panel3.add(idLabel);
        panel3.add(idText);
        panel3.add(durationLabel);
        panel3.add(durationText);
        panel3.add(notesText);
        panel3.add(picButton);
        panel3.add(saveButton);
        panel3.add(resetButton);
        panel3.add(saveMessageLabel);
        panel3.add(firstOption);


        frame3.add(panel3);

        frame3.setSize(1000, 700);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);


    }


    public void keyPressed(KeyEvent e) {
        int code = e.getKeyChar();

        if ((e.getSource() == nameText) && (code == 10)) {
            nameVal();
        } else if ((e.getSource() == surnameText) && (code == 10)) {
            surNameVal();
        } else if ((e.getSource() == dobText) && (code == 10)) {
            dobIDVal();
        } else if ((e.getSource() == mobileNoText) && (code == 10)) {
            mobileNumVal();
        } else if ((e.getSource() == idText) && (code == 10)) {
            idVal();
        } else if ((e.getSource() == durationText) && (code == 10)) {
            durationVal();
        } else if ((e.getSource() == notesText) && (code == 10)) {
            notesVal();
        } else if ((e.getSource() == dateText) && (code == 10)) {
            dateVal();
        } else if ((e.getSource() == timeText) && (code == 10)) {
            timeVal();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void nameVal() {
        String name = nameText.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            nameText.requestFocus();
        } else {
            surnameText.setEditable(true);
            surnameText.requestFocus();
        }
    }

    public void surNameVal() {
        String surName = surnameText.getText();

        if (surName.equals("")) {
            JOptionPane.showMessageDialog(null, "Sur name can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            surnameText.requestFocus();
        } else {
            dobText.setEditable(true);
            dobText.requestFocus();
        }
    }

    public void dobIDVal() {
        String dob = dobText.getText();

        if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Date of birth can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            dobText.requestFocus();
        } else {
            boolean result = dateForVal(dob);
            if (result == false) {
                JOptionPane.showMessageDialog(null, "Invalid Format", "Error", JOptionPane.ERROR_MESSAGE);
                dobText.requestFocus();
                dobText.setText("");
            } else {
                mobileNoText.setEditable(true);
                mobileNoText.requestFocus();
            }
        }
    }

    public boolean dateForVal(String dob) {
        boolean output = false;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        try {
            date = df.parse(dob);
            output = true;
        } catch (Exception e) {
            output = false;
        }
        return output;
    }

    public void durationVal() {
        String duration = durationText.getText();

        if (duration.equals("")) {
            JOptionPane.showMessageDialog(null, "Duration can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            durationText.requestFocus();
        } else {
            for (int i = 0; i < duration.length(); i++) {
                if (!Character.isDigit(duration.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Duration contains only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    durationText.requestFocus();
                    durationText.setText("");
                    break;
                } else {
                    notesText.setEditable(true);
                    notesText.requestFocus();
                }
            }
        }
    }

    public void mobileNumVal() {
        String mobileNumber = mobileNoText.getText();

        if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Mobile number can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            mobileNoText.requestFocus();
        } else if (mobileNumber.length() != 10) {
            JOptionPane.showMessageDialog(null, "Moblie number length should be 10", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < mobileNumber.length(); i++) {
                if (!Character.isDigit(mobileNumber.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Moblie number contain only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    mobileNoText.requestFocus();
                    mobileNoText.setText("");
                    break;
                } else {
                    idText.setEditable(true);
                    idText.requestFocus();
                }
            }
        }
    }

    public void idVal() {
        String id = idText.getText();

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "ID can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            idText.requestFocus();
        } else {
            durationText.requestFocus();
            durationText.setEditable(true);
        }
    }

    public void notesVal() {
        String notes = notesText.getText();

        if (notes.equals("")) {
            JOptionPane.showMessageDialog(null, "Notes can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            notesText.requestFocus();
        }
    }

    public void dateVal() {
        String dob = dobText.getText();

        if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Date can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            dobText.requestFocus();
        } else {
            boolean result = dateForVal(dob);
            if (result == false) {
                JOptionPane.showMessageDialog(null, "Invalid Format", "Error", JOptionPane.ERROR_MESSAGE);
                dobText.requestFocus();
                dobText.setText("");
            } else {
                mobileNoText.setEditable(true);
                mobileNoText.requestFocus();
            }
        }
    }

    public void timeVal() {

    }

    private static JOptionPane firstOption = new JOptionPane();
    private static JOptionPane secondOption = new JOptionPane();

    public void reset() {
        nameText.setText(" ");
        surnameText.setText(" ");
        dobText.setText(" ");
        mobileNoText.setText(" ");
        ;
        idText.setText(" ");
        durationText.setText(" ");
        notesText.setText(" ");

    }

    private void checkAvailability() throws IOException {
        //String text = doctorName + " " + date + " " + time;
        if (checkInTextFile("Consultation.txt", doctorOption.getSelectedItem().toString() + " " + dateText.getText() + " " + timeText.getText())) {
            System.out.println("This slot has been already booked by someone else.. SORRY:(((((");
            warning = new JFrame();
            JOptionPane.showMessageDialog(warning, "This slot has been booked by someone else:(", "Alert", JOptionPane.WARNING_MESSAGE);
            Random random = new Random();
            String randomName = choices[random.nextInt(10)];
            doctorName = randomName;
            try {
                fw.write(doctorName + " " + dateText.getText() + " " + timeText.getText() + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            secondOption.showMessageDialog(null, "Therefore, Doctor " + randomName + " has been assigned to you with the same date & time", "Message", JOptionPane.INFORMATION_MESSAGE);
            secondOption.showMessageDialog(null, "Please Enter your personal details to confirm booking", "Message", JOptionPane.INFORMATION_MESSAGE);
            frame4.dispose();
            personalDetails();

        } else {
            System.out.println("Booking Successfully Done");
            doctorName = doctorOption.getSelectedItem().toString();
            secondOption.showMessageDialog(null, "Booking Successfully Done", "Message", JOptionPane.INFORMATION_MESSAGE);
            secondOption.showMessageDialog(null, "Please Enter your personal details to confirm booking", "Message", JOptionPane.INFORMATION_MESSAGE);
            frame4.dispose();
            personalDetails();

            try {
                fw.write(doctorOption.getSelectedItem().toString() + " " + dateText.getText() + " " + timeText.getText() + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean checkInTextFile(String logFile, String text) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(logFile));
            String s;
            while ((s = buff.readLine()) != null) {
                if (s.trim().contains(text)) {
                    return true;
                }
            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveConsultationDetails() throws IOException {
        fw = new FileWriter("ConsultationDetails.txt", true);
        try {
            for (int i = 0; i < personaldetailsList.size(); i++) {
                fw.write(personaldetailsList.get(i) + "\n");
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewAllConsultationDetails() throws FileNotFoundException {
        File file = new File("ConsultationDetails.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {

            String[] arrOfStr = scan.nextLine().split(",");
            if (arrOfStr.length > 1) {
                consulationDetails.add(new ConsulationDetails(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6], arrOfStr[7], arrOfStr[8], arrOfStr[9], arrOfStr[10]));
            }
        }
        conDetails();
    }

    public void loadFileArray() throws IOException, ClassNotFoundException {
        doctorArray.removeAll(doctorArray);
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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewDoctorButton) {
            frame1.dispose();
            doctorDetails();
        } else if (e.getSource() == bookDoctorButton) {
            frame1.dispose();
            bookDoctor();

        } else if (e.getSource() == consultationDetailButton) {
            frame1.dispose();

            String password = JOptionPane.showInputDialog("This is only for the admins. Please enter the password if you are an admin:)");
            if (password.equalsIgnoreCase("1234")) {
                JOptionPane.showMessageDialog(null, "Password Correct, Check Console for all the details of the entire consultation history.", "Admin", JOptionPane.PLAIN_MESSAGE);
                try {
                    viewAllConsultationDetails();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password entered", "Admin", JOptionPane.WARNING_MESSAGE);
            }


        } else if (e.getSource() == alphabeticalOrder) {
            sortDoctor();

            tableModel.setRowCount(0);
            for (int i = 0; i < doctorArray.size(); i++) {
                tableModel.insertRow(i, new Object[]{doctorArray.get(i).getName(), doctorArray.get(i).getSurname(), doctorArray.get(i).getDOB(), doctorArray.get(i).getNumber(), doctorArray.get(i).getLicenseNumber(), doctorArray.get(i).getSpecialisation()});
            }
            tableModel.fireTableDataChanged();

        } else if (e.getSource() == picButton) {
            encryptImage(1234);

        } else if (e.getSource() == saveButton) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] data = new byte[fis.available()];
                fis.read(data);
                int i = 0;
                for (byte b : data) {

                    data[i] = (byte) (b ^ 1234);
                    i++;
                }

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data);
                fos.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            personaldetailsList.add(nameText.getText() + "," + surnameText.getText() + "," + dobText.getText() + "," + mobileNoText.getText() + "," + idText.getText() + "," + durationText.getText() + "," + notesText.getText() + "," + doctorName + "," + dateText.getText() + "," + timeText.getText() + "," + fileName);
            try {
                File file = new File("ConsultationDetails.txt");
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {

                    String[] arrOfStr = scan.nextLine().split(",");
                    if (arrOfStr.length > 1) {
                        consulationDetails.add(new ConsulationDetails(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6], arrOfStr[7], arrOfStr[8], arrOfStr[9], arrOfStr[10]));
                    }
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Consultation consultation = new Consultation("", "", "", "");
            for (int i = 0; i < consulationDetails.size(); i++) {
                System.out.println(consulationDetails.get(i).getId());


                if (consulationDetails.get(i).getId().equals(idText.getText())) {

                    consultation.setCost(Integer.parseInt(durationText.getText()) * 25);
                } else {
                    consultation.setCost(Integer.parseInt(durationText.getText()) * 15);

                }
            }
            try {
                File file = new File("ConsultationDetails.txt");
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {

                    String[] arrOfStr = scan.nextLine().split(",");
                    if (arrOfStr.length > 1) {
                        consulationDetails.add(new ConsulationDetails(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6], arrOfStr[7], arrOfStr[8], arrOfStr[9], arrOfStr[10]));
                    }
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Name: " + nameText.getText() + "\nSurname: " + surnameText.getText() + "\nD.O.B : " + dobText.getText() + "\nMobile Number : " + mobileNoText.getText() + "\nID Number : " + idText.getText() + "\nDuration of Consultation : " + durationText.getText() + "\nTotal Cost : " + consultation.getCost() + "\nAssigned Doctor : " + doctorName + "\nBooking Date : " + dateText.getText() + "\nBooking Time : " + timeText.getText() + "\nDo you want to continue", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            firstOption.showMessageDialog(null, "Successfully Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
            try {
                saveConsultationDetails();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame3.dispose();
            try {
                new DoctorDetailsGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == bookButton) {
            try {
                checkAvailability();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == exitButton) {
            System.exit(0);

        } else if (e.getSource() == resetButton) {
            reset();
        }
    }

    static File file = null;
    static String fileName = null;

    public static void encryptImage(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();
        fileName = String.valueOf(file.getAbsoluteFile());
        System.out.println(fileName);
        //file FileInputStream

    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;

    private String label;

    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });


    }


    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText("View");


        ImageOperation1.imageUrl = DoctorDetailsGUI.consulationDetails.get(row).getImageURL();

        FileInputStream fis = null;

        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(ImageOperation1.imageUrl);
            byte data[] = new byte[fis.available()];


            fis.read(data);
            int i = 0;

            for (byte b : data) {
                data[i] = (byte) (b ^ 1234);
                i++;
            }


            fos = new FileOutputStream(ImageOperation1.imageUrl);

            fos.write(data);
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        new ImageOperation1();
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
