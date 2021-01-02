import javax.swing.*;
import java.awt.*;

public class AddingDialog extends JDialog {

    private final static int XOFFSET = ClubMembership.getXOffset() + 300;
    private final static int YOFFSET = ClubMembership.getYOffset() + 200;
    private final static int WIDTH  = 500;
    private final static int HEIGHT = 300;

    private final static JLabel NUMBER = new JLabel("Number");
    private final static JLabel FIRSTNAME = new JLabel("First name");
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATEOFBIRTH = new JLabel("Date of birth");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");


    private MyTextField textNumber = new MyTextField("Number");
    private MyTextField textFirstname = new MyTextField("First name");
    private MyTextField textLastname = new MyTextField("Last name");
    private MyTextField textBirth = new MyTextField("Birthday");
    private JRadioButton radioGender = new JRadioButton();
    private MyTextField textAddress = new MyTextField("Address");
    private MyTextField textTelephone = new MyTextField("Telephone");

    public AddingDialog() {
        setModal(true);
        setTitle("Information");
        setBounds(XOFFSET,YOFFSET,WIDTH,HEIGHT);

        JPanel panel = new JPanel();
        add(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(10)
                .addGroup(layout.createParallelGroup().addComponent(NUMBER)
                                                    .addComponent(LASTNAME)).addGap(10)
                        .addGroup(layout.createParallelGroup().addComponent(textNumber)
                                                            .addComponent(textLastname)).addGap(10)
                                .addGroup(layout.createParallelGroup().addComponent(FIRSTNAME)
                                                                    .addComponent(DATEOFBIRTH)).addGap(10)
                                        .addGroup(layout.createParallelGroup().addComponent(textFirstname)
                                                                            .addComponent(textBirth)).addGap(10)
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(NUMBER).addComponent(textNumber).addComponent(FIRSTNAME).addComponent(textFirstname))
                .addGap(10)
                .addGroup(layout.createParallelGroup().addComponent(LASTNAME).addComponent(textLastname).addComponent(DATEOFBIRTH).addComponent(textBirth))
                .addGap(300)
        );

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}
