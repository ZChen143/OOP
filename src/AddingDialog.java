import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Pattern;

public class AddingDialog extends JDialog implements ActionListener{

    private final static int XOFFSET = ClubMembership.getXOffset() + 200;
    private final static int YOFFSET = ClubMembership.getYOffset() + 100;
    private final static int WIDTH  = 600;
    private final static int HEIGHT = 220;

    private final static JLabel FIRSTNAME = new JLabel("First name");
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATEOFBIRTH = new JLabel("Birthday");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");


    private final MyTextField textFirstname = new MyTextField("First name");
    private final MyTextField textLastname = new MyTextField("Last name");
    private final MyTextField textBirthday = new MyTextField("31/01/70");
    private final JComboBox GenderComboBox = new JComboBox();
    private final MyTextField textAddress = new MyTextField("Address");
    private final MyTextField textTelephone = new MyTextField("Start with +44 or 0");

    private final JButton save = new JButton("Save");
    private final JButton cancel = new JButton("Cancel");

    public AddingDialog() {

        //GenderComboBox.setMaximumSize(textNumber.getSize());
        GenderComboBox.addItem("");
        GenderComboBox.addItem("Male");
        GenderComboBox.addItem("Female");
        GenderComboBox.addItem("Other");
        GenderComboBox.addItem("prefer not to disclose");

        save.addActionListener(this);
        cancel.addActionListener(this);

        setModal(true);
        setTitle("Information");
        setBounds(XOFFSET,YOFFSET,WIDTH,HEIGHT);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(FIRSTNAME)
                        .addComponent(DATEOFBIRTH)
                        .addComponent(ADDRESS))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textFirstname)
                                .addComponent(textBirthday)
                                .addComponent(textAddress)
                                .addComponent(save)).addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LASTNAME)
                                        .addComponent(GENDER)
                                        .addComponent(TELEPHONE)
                                        .addComponent(cancel))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(textLastname)
                                                .addComponent(GenderComboBox)
                                                .addComponent(textTelephone)).addGap(20)
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(FIRSTNAME).addComponent(textFirstname).addComponent(LASTNAME).addComponent(textLastname))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(DATEOFBIRTH).addComponent(textBirthday).addComponent(GENDER).addComponent(GenderComboBox))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(ADDRESS).addComponent(textAddress).addComponent(TELEPHONE).addComponent(textTelephone))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(save).addComponent(cancel))
        );

        layout.linkSize(textFirstname,textLastname,GenderComboBox,textTelephone,textAddress,textBirthday);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(save)){
            if(isCorrect()){
                String[] customer = new String[]{
                        null,
                        textFirstname.getText(), textLastname.getText(), textBirthday.getText(),
                        Objects.requireNonNull(GenderComboBox.getSelectedItem()).toString(), textAddress.getText(), textTelephone.getText(),
                        null,null
                };
                ClubMembership.getCustomer().createNumNo(customer);
                ClubMembership.getCustomer().addCustomer(customer);
                dispose();
            }
            else {
                System.err.println("error");
            }
        }
        else if(e.getSource().equals(cancel)){
            dispose();
        }
    }

    public boolean isCorrect() {

        String telephoneFormat = "(\\+44|0)7[0-9]{9}";
        String dateFormat = "(((0[1-9]|[12][0-9]|3[01])\\/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)\\/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])\\/(02))\\/[0-9]{2})|(29\\/02\\/([02468][048]|[13579][26]))";

        return !textFirstname.getText().equals("")
                && !textLastname.getText().equals("")
                && !Objects.requireNonNull(GenderComboBox.getSelectedItem()).toString().equals("")
                && Pattern.matches(dateFormat,textBirthday.getText())
                && !textAddress.getText().equals("")
                && Pattern.matches(telephoneFormat,textTelephone.getText());
    }
}
