import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddingDialog extends JDialog implements ActionListener{

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
    private JComboBox GenderComboBox = new JComboBox();
    private MyTextField textAddress = new MyTextField("Address");
    private MyTextField textTelephone = new MyTextField("Telephone");

    private JButton save = new JButton("Save");
    private JButton cancel = new JButton("Cancel");

    private String dateFormat = "(((0[1-9]|[12][0-9]|3[01])/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])/(02))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29/02/(([0-9]{2})))";

    public AddingDialog() {

        GenderComboBox.addItem("Male");
        GenderComboBox.addItem("Female");
        GenderComboBox.addItem("Other");
        GenderComboBox.addItem("prefer not to disclose");

        save.addActionListener(this);
        cancel.addActionListener(this);

        setModal(true);
        setTitle("Information");
        setBounds(XOFFSET,YOFFSET,WIDTH,HEIGHT);

        JPanel panel = new JPanel();
        add(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(NUMBER)
                                                    .addComponent(LASTNAME)
                                                    .addComponent(GENDER)
                                                    .addComponent(TELEPHONE))
                        .addGroup(layout.createParallelGroup().addComponent(textNumber)
                                                            .addComponent(textLastname)
                                                            .addComponent(GenderComboBox)
                                                            .addComponent(textTelephone)
                                                            .addComponent(save))
                                .addGroup(layout.createParallelGroup().addComponent(FIRSTNAME)
                                                                    .addComponent(DATEOFBIRTH)
                                                                    .addComponent(ADDRESS)
                                                                    .addComponent(cancel))
                                        .addGroup(layout.createParallelGroup().addComponent(textFirstname)
                                                                            .addComponent(textBirth)
                                                                            .addComponent(textAddress)).addGap(20)
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(NUMBER).addComponent(textNumber).addComponent(FIRSTNAME).addComponent(textFirstname))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(LASTNAME).addComponent(textLastname).addComponent(DATEOFBIRTH).addComponent(textBirth))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(GENDER).addComponent(GenderComboBox).addComponent(ADDRESS).addComponent(textAddress))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(TELEPHONE).addComponent(textTelephone))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(save).addComponent(cancel))
                .addGap(300)
        );

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(save)){
            if(textBirth.getText().matches(dateFormat)){
                System.out.println("true");
            }
            else
                System.out.println("false");
        }
        else if(e.getSource().equals(cancel)){
            dispose();
        }
    }
}
