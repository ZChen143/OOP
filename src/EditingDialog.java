import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Vector;
import java.util.regex.Pattern;

public class EditingDialog extends MyDialog implements ActionListener {
    public EditingDialog() {
        super(new JButton("Confirm"), new JButton("cancel"));

        int row = ClubMembership.getTable().getSelectedRow();
        Vector<String> customer = ClubMembership.getCustomer().getCustomer().get(row);
        getTextFirstname().setText(customer.get(1));
        getTextLastname().setText(customer.get(2));
        getTextBirthday().setText(customer.get(3));
        getGenderComboBox().setSelectedIndex(DetailsDialog.gender(customer.get(4)));
        getTextAddress().setText(customer.get(5));
        getTextTelephone().setText(customer.get(6));
        getTextStartDate().setText(customer.get(8));
        getMembershipComBox().setSelectedIndex(DetailsDialog.membership(customer.get(10)));
        getTextMemNO().setText(customer.get(0));

        getDueDate().setVisible(false);
        getAGE().setVisible(false);
        getFEE().setVisible(false);
        getMembershipNumber().setVisible(true);
        getLabelDueDate().setVisible(false);
        getLabelAge().setVisible(false);
        getLabelFee().setVisible(false);
        getTextMemNO().setVisible(true);
        getTextMemNO().setEditable(false);

        setTitle("Editing");
        setSize(MyDialog.WIDTH,MyDialog.HEIGHT+50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getButton1())){
            if(isCorrect()){
                int row = ClubMembership.getTable().getSelectedRow();

                String[] customer = new String[]{
                        getTextMemNO().getText(),// Membership number
                        getTextFirstname().getText(), getTextLastname().getText(), getTextBirthday().getText(),
                        Objects.requireNonNull(getGenderComboBox().getSelectedItem()).toString(), getTextAddress().getText(), getTextTelephone().getText(),
                        null,// Age
                        getTextStartDate().getText(),null,// Due date
                        Objects.requireNonNull(getMembershipComBox().getSelectedItem()).toString(),
                        null// FEE
                };
                //ClubMembership.getCustomer().createNumNo(customer);
                System.out.println(customer[Customer.MEMBERSHIP_NUMBER]);
                ClubMembership.getCustomer().calculateAge(customer);
                ClubMembership.getCustomer().calculateDueDate(customer);
                String membership = customer[Customer.MEMBERSHIP];
                int age = Integer.parseInt(customer[Customer.AGE]);
                if( ((membership.equals("family/year") || membership.equals("family/month")) && age >= 12) || age >= 18) {
                    for (int i = 0; i < MyTable.HEDA_LENGTH; i++) {
                        ClubMembership.getCustomer().getCustomer().get(row).set(i, customer[i]);
                    }
                    JOptionPane.showMessageDialog(getContentPane(), "Success!");
                    dispose();
                    ClubMembership.getTable().updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(getContentPane(), "Check age!");
                }
            }
            else
                JOptionPane.showMessageDialog(getContentPane(), "Check the information!");
        }
        else if(e.getSource().equals(getButton2())){
            dispose();
        }
    }

    public boolean isCorrect() {
        // Could start with +44 or 0 and first digit of telephone must be 7.
        String telephoneFormat = "(\\+44|0)?7[0-9]{9}";
        // dd/MM/yy Due to only keep the last two digits of the year. ALL the years in multiples of 4 seem as leap years.
        // That means I assume all customers are born from 1942 to 2041.
        String dateFormat = "(((0[1-9]|[12][0-9]|3[01])\\/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)\\/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])\\/(02))\\/[0-9]{2})|(29\\/02\\/([02468][048]|[13579][26]))";

        return !getTextFirstname().getText().equals("")
                && !getTextLastname().getText().equals("")
                && getGenderComboBox().getSelectedItem() != null
                && Pattern.matches(dateFormat,getTextBirthday().getText())
                && !getTextAddress().getText().equals("")
                && Pattern.matches(telephoneFormat,getTextTelephone().getText())
                && Pattern.matches(dateFormat,getTextStartDate().getText())
                && !Objects.requireNonNull(getMembershipComBox().getSelectedItem()).toString().equals("");
    }
}
