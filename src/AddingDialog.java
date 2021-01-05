import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Pattern;

public class AddingDialog extends MyDialog implements ActionListener{

    public AddingDialog() {
        super(new JButton("save"), new JButton("cancel"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getButton1())){
            if(isCorrect()){
                String[] customer = new String[]{
                        null,
                        getTextFirstname().getText(), getTextLastname().getText(), getTextBirthday().getText(),
                        Objects.requireNonNull(getGenderComboBox().getSelectedItem()).toString(), getTextAddress().getText(), getTextTelephone().getText(),
                        null,getTextStartDate().getText(),null
                };
                ClubMembership.getCustomer().createNumNo(customer);
                ClubMembership.getCustomer().addCustomer(customer);
                JOptionPane.showMessageDialog(getContentPane(), "Success!");
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(getContentPane(), "Check the information!");
            }
        }
        else if(e.getSource().equals(getButton2())){
            dispose();
        }
    }

    public boolean isCorrect() {
        //Could start with +44 or 0 and first digit of telephone must be 7.
        String telephoneFormat = "(\\+44|0)?7[0-9]{9}";
        //dd/MM/yy, due to only keep the last two digits of the year. ALL the years in multiples of 4 seem as leap years.
        String dateFormat = "(((0[1-9]|[12][0-9]|3[01])\\/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)\\/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])\\/(02))\\/[0-9]{2})|(29\\/02\\/([02468][048]|[13579][26]))";

        return !getTextFirstname().getText().equals("")
                && !getTextLastname().getText().equals("")
                && !Objects.requireNonNull(getGenderComboBox().getSelectedItem()).toString().equals("")
                && Pattern.matches(dateFormat,getTextBirthday().getText())
                && !getTextAddress().getText().equals("")
                && Pattern.matches(telephoneFormat,getTextTelephone().getText());
    }
}
