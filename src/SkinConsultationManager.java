import java.awt.event.ActionEvent;
import java.io.IOException;

public interface SkinConsultationManager {
    void addDoctor();

    void deleteDoctor();

    void printDoctor();

    void saveFile() throws IOException;

    void loadFile() throws IOException, ClassNotFoundException;

    ActionEvent loadGUI() throws IOException;


}
