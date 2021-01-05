import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MyDialog extends JDialog implements ActionListener {

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

    private final JButton button1;
    private final JButton button2;

    public MyDialog(JButton botton1, JButton botton2){

        this.button1 = botton1;
        this.button2 = botton2;

        botton1.addActionListener(this);
        botton2.addActionListener(this);

        GenderComboBox.addItem("");
        GenderComboBox.addItem("Male");
        GenderComboBox.addItem("Female");
        GenderComboBox.addItem("Other");
        GenderComboBox.addItem("prefer not to disclose");

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
                        .addComponent(button1)).addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(LASTNAME)
                        .addComponent(GENDER)
                        .addComponent(TELEPHONE)
                        .addComponent(button2))
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
                .addGroup(layout.createParallelGroup().addComponent(button1).addComponent(botton2))
        );

        layout.linkSize(textFirstname,textLastname,GenderComboBox,textTelephone,textAddress,textBirthday);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public MyTextField getTextFirstname() {
        return textFirstname;
    }

    public MyTextField getTextLastname() {
        return textLastname;
    }

    public MyTextField getTextBirthday() {
        return textBirthday;
    }

    public JComboBox getGenderComboBox() {
        return GenderComboBox;
    }

    public MyTextField getTextAddress() {
        return textAddress;
    }

    public MyTextField getTextTelephone() {
        return textTelephone;
    }


}
