import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImageOperation1 extends JFrame {
    JLabel label;

    public static String imageUrl;

    public ImageOperation1() {
        super("Set Picture Into A JLabel Using JFileChooser In Java");
        label = new JLabel();
        label.setBounds(10, 10, 670, 250);

        add(label);

        label.setIcon(ResizeImage(imageUrl));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);
        setVisible(true);
    }

    // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public static void main(String[] args) {

    }
}