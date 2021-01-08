import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MyDialog extends JDialog implements ActionListener {

    private final static int X_OFFSET = ClubMembership.getXOffset() + 200;
    private final static int Y_OFFSET = ClubMembership.getYOffset() + 100;
    public final static int WIDTH  = 600;
    public final static int HEIGHT = 320;

    private final static JLabel FIRSTNAME = new JLabel("First name   ");
    private final static JLabel LASTNAME = new JLabel("Last name");
    private final static JLabel DATE_OF_BIRTH = new JLabel("Birthday");
    private final static JLabel GENDER = new JLabel("Gender");
    private final static JLabel ADDRESS = new JLabel("Address");
    private final static JLabel TELEPHONE = new JLabel("Telephone");
    private final static JLabel START_DATE = new JLabel("Start date");
    private final static JLabel MEMBERSHIP = new JLabel("Membership");
    private final static JLabel DUE_DATE = new JLabel("Due date");
    private final static JLabel AGE = new JLabel("Age");
    private final static JLabel FEE = new JLabel("Fee");
    private final static JLabel MEMBERSHIP_NUMBER = new JLabel("Membership NO.");


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
    private final MyTextField textMemNO = new MyTextField("Membership NO.");

    private final JButton button1;
    private final JButton button2;

    public MyDialog(JButton button1, JButton button2){

        this.button1 = button1;
        this.button2 = button2;

        button1.addActionListener(this);
        button2.addActionListener(this);

        GenderComboBox.addItem("");
        GenderComboBox.addItem("male");
        GenderComboBox.addItem("female");
        GenderComboBox.addItem("others");
        GenderComboBox.addItem("prefer not to disclose");

        membershipComBox.addItem("");
        membershipComBox.addItem("individual/year");
        membershipComBox.addItem("individual/month");
        membershipComBox.addItem("family/year");
        membershipComBox.addItem("family/month");
        membershipComBox.addItem("visitor");

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
                        .addComponent(MEMBERSHIP_NUMBER)
                        .addComponent(button2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textLastname)
                        .addComponent(GenderComboBox)
                        .addComponent(textTelephone)
                        .addComponent(membershipComBox)
                        .addComponent(labelFee)
                        .addComponent(textMemNO)).addGap(20)
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(AGE).addComponent(labelAge).addComponent(MEMBERSHIP_NUMBER).addComponent(textMemNO))
                .addGap(20)
                .addGroup(layout.createParallelGroup().addComponent(button1).addComponent(button2))
                .addGap(20)
        );

        layout.linkSize(textFirstname,textLastname,GenderComboBox,textTelephone,textAddress,textBirthday,textStartDate,membershipComBox,labelDueDate,labelFee,labelAge,textMemNO);
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


    public MyTextField getTextStartDate() {
        return textStartDate;
    }

    public static JLabel getMEMBERSHIP() {
        return MEMBERSHIP;
    }

    public static JLabel getDueDate() {
        return DUE_DATE;
    }

    public static JLabel getAGE() {
        return AGE;
    }

    public static JLabel getFEE() {
        return FEE;
    }

    public static JLabel getMembershipNumber() {
        return MEMBERSHIP_NUMBER;
    }

    public JComboBox getMembershipComBox() {
        return membershipComBox;
    }

    public JLabel getLabelDueDate() {
        return labelDueDate;
    }

    public JLabel getLabelAge() {
        return labelAge;
    }

    public JLabel getLabelFee() {
        return labelFee;
    }

    public MyTextField getTextMemNO() {
        return textMemNO;
    }

}
