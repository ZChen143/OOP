import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MyDialog extends JDialog implements ActionListener {

    private final static int X_OFFSET = ClubMembership.getXOffset() + 200;
    private final static int Y_OFFSET = ClubMembership.getYOffset() + 100;
    private final static int WIDTH  = 600;
    private final static int HEIGHT = 320;

    private final static JLabel FIRSTNAME = new JLabel("First name   ");;
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATE_OF_BIRTH = new JLabel("Birthday");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");
    private final static JLabel START_DATE = new JLabel("Start date");
    private final static JLabel MEMBERSHIP = new JLabel("Membership");
    private final static JLabel DUE_DATE = new JLabel("Due date");
    private final static JLabel AGE = new JLabel("Age:");
    private final static JLabel FEE = new JLabel("Fee/month:");

    private final MyTextField textFirstname = new MyTextField("First name");
    private final MyTextField textLastname = new MyTextField("Last name");
    private final MyTextField textBirthday = new MyTextField("28/02/70");
    private final JComboBox GenderComboBox = new JComboBox();
    private final MyTextField textAddress = new MyTextField("Address");
    private final MyTextField textTelephone = new MyTextField("(+44)(0)7123456789");
    private final MyTextField textStartDate = new MyTextField("29/02/20");
    private final JComboBox membershipComBox = new JComboBox();
    private final JLabel labelDueDate = new JLabel();
    private final JLabel labelAge = new JLabel();
    private final JLabel labelFee = new JLabel();

    private final JButton button1;
    private final JButton button2;

    public MyDialog(JButton button1, JButton button2){

        this.button1 = button1;
        this.button2 = button2;

        button1.addActionListener(this);
        button2.addActionListener(this);

        GenderComboBox.addItem("");
        GenderComboBox.addItem("Male");
        GenderComboBox.addItem("Female");
        GenderComboBox.addItem("Other");
        GenderComboBox.addItem("prefer not to disclose");

        membershipComBox.addItem("");
        membershipComBox.addItem("Individual");
        membershipComBox.addItem("Family");
        membershipComBox.addItem("Visitor");

        setModal(true);
        setTitle("Information");
        setBounds(X_OFFSET,Y_OFFSET,WIDTH,HEIGHT);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);



        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(FIRSTNAME)
                        .addComponent(DATE_OF_BIRTH)
                        .addComponent(ADDRESS)
                        .addComponent(START_DATE)
                        .addComponent(DUE_DATE)
                        .addComponent(AGE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textFirstname)
                        .addComponent(textBirthday)
                        .addComponent(textAddress)
                        .addComponent(textStartDate)
                        .addComponent(labelDueDate)
                        .addComponent(labelAge)
                        .addComponent(button1)).addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(LASTNAME)
                        .addComponent(GENDER)
                        .addComponent(TELEPHONE)
                        .addComponent(MEMBERSHIP)
                        .addComponent(FEE)
                        .addComponent(button2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textLastname)
                        .addComponent(GenderComboBox)
                        .addComponent(textTelephone)
                        .addComponent(membershipComBox)
                        .addComponent(labelFee)).addGap(20)
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(FIRSTNAME).addComponent(textFirstname).addComponent(LASTNAME).addComponent(textLastname))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(DATE_OF_BIRTH).addComponent(textBirthday).addComponent(GENDER).addComponent(GenderComboBox))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(ADDRESS).addComponent(textAddress).addComponent(TELEPHONE).addComponent(textTelephone))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(START_DATE).addComponent(textStartDate).addComponent(MEMBERSHIP).addComponent(membershipComBox))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(DUE_DATE).addComponent(labelDueDate).addComponent(FEE).addComponent(labelFee))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(AGE).addComponent(labelAge))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(button1).addComponent(button2))
                .addGap(20)
        );

        layout.linkSize(textFirstname,textLastname,GenderComboBox,textTelephone,textAddress,textBirthday,textStartDate,membershipComBox,labelDueDate,labelFee,labelAge);
        layout.linkSize(button1,button2);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

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
