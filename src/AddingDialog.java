import javax.swing.*;
import java.awt.*;

public class AddingDialog extends JDialog {

    private final static JLabel NUMBER = new JLabel("Number");
    private final static JLabel FIRSTNAME = new JLabel("First name");
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATEOFBIRTH = new JLabel("Date of birth");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");

    public AddingDialog() {
        setModal(true);
        setBounds(660,300,500,300);

        JPanel panel = new JPanel();
        add(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(NUMBER));

        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(NUMBER));

        setVisible(true);
    }
}
