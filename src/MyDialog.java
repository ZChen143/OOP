import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MyDialog extends JDialog implements ActionListener {

    private final static int XOFFSET = ClubMembership.getXOffset() + 200;
    private final static int YOFFSET = ClubMembership.getYOffset() + 100;
    private final static int WIDTH  = 600;
    private final static int HEIGHT = 280;

    private final static JLabel FIRSTNAME = new JLabel("First name   ");
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATEOFBIRTH = new JLabel("Birthday");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");
    private final static JLabel STARTDATE = new JLabel("Start date");


    private final MyTextField textFirstname = new MyTextField("First name");
    private final MyTextField textLastname = new MyTextField("Last name");
    private final MyTextField textBirthday = new MyTextField("28/02/70");
    private final JComboBox GenderComboBox = new JComboBox();
    private final MyTextField textAddress = new MyTextField("Address");
    private final MyTextField textTelephone = new MyTextField("(+44)(0)7123456789");
    private final MyTextField textStartDate = new MyTextField("29/02/20");

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
                        .addComponent(ADDRESS)
                        .addComponent(STARTDATE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textFirstname)
                        .addComponent(textBirthday)
                        .addComponent(textAddress)
                        .addComponent(textStartDate)
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(STARTDATE).addComponent(textStartDate))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(button1).addComponent(botton2))
        );

        layout.linkSize(textFirstname,textLastname,GenderComboBox,textTelephone,textAddress,textBirthday,textStartDate);
        layout.linkSize(botton1,botton2);

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

    public void setTextFirstname(String firstname) {
        textFirstname.setText(firstname);
    }

    public MyTextField getTextLastname() {
        return textLastname;
    }

    public void setTextLastname(String lastname) {
        textLastname.setText(lastname);
    }

    public MyTextField getTextBirthday() {
        return textBirthday;
    }

    public void setTextBirthday(String birthday) {
        textBirthday.setText(birthday);
    }

    public JComboBox getGenderComboBox() {
        return GenderComboBox;
    }

    public void setGender(String gender) {
        GenderComboBox.setSelectedItem(gender);
    }

    public MyTextField getTextAddress() {
        return textAddress;
    }

    public void setTextAddress(String address) {
        textAddress.setText(address);
    }

    public MyTextField getTextTelephone() {
        return textTelephone;
    }

    public void setTextTelephone(String telephone) {
        textTelephone.setText(telephone);
    }

    public MyTextField getTextStartDate() {
        return textStartDate;
    }

    public void setTextStartDate(String startDate) {
        textStartDate.setText(startDate);
    }
}
