import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Pattern;

public class SearchingDialog extends MyDialog implements ActionListener {

    public SearchingDialog() {
        super(new JButton("search"), new JButton("cancel"));
        getDueDate().setVisible(false);
        getAGE().setVisible(false);
        getFEE().setVisible(false);
        getMembershipNumber().setVisible(true);
        getLabelDueDate().setVisible(false);
        getLabelAge().setVisible(false);
        getLabelFee().setVisible(false);
        getTextMemNO().setVisible(true);
        setSize(MyDialog.WIDTH,MyDialog.HEIGHT+20);

        setTitle("Searching");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] customer;
        if(e.getSource().equals(getButton1())){
            if(isCorrect()) {
                customer = new String[]{ // using null or "" is different.
                        // This array gets some useless information which is always be null.
                        // However, it still can work so I don't want to modify.
                        getTextMemNO().getText(),// Membership number
                        getTextFirstname().getText(), getTextLastname().getText(), getTextBirthday().getText(),
                        Objects.requireNonNull(getGenderComboBox().getSelectedItem()).toString(), getTextAddress().getText(), getTextTelephone().getText(),
                        "",// Age
                        getTextStartDate().getText(), "",// Due date
                        Objects.requireNonNull(getMembershipComBox().getSelectedItem()).toString(),
                        ""// FEE
                };
                find(customer);
            }
            dispose();
        }
        else if(e.getSource().equals(getButton2())){
            dispose();
        }
    }
    public boolean isCorrect() {
        String telephoneFormat = "(\\+44|0)?7[0-9]{9}";
        String dateFormat = "(((0[1-9]|[12][0-9]|3[01])\\/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)\\/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])\\/(02))\\/[0-9]{2})|(29\\/02\\/([02468][048]|[13579][26]))";

        return (Pattern.matches(dateFormat,getTextBirthday().getText()) || getTextBirthday().getText().equals(""))
                && (Pattern.matches(telephoneFormat,getTextTelephone().getText()) || getTextTelephone().getText().equals(""))
                && (Pattern.matches(dateFormat,getTextStartDate().getText()) || getTextStartDate().getText().equals(""));
    }

    public static void find(String[] customer){
        boolean flag = true;
        JTable t = ClubMembership.getTable();
        t.setRowSelectionAllowed(true);
        t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // select multiple rows
        for(int i = 0; i < MyTable.HEDA_LENGTH; i++){
            while(customer[i].equals("") && i+1 < MyTable.HEDA_LENGTH) // skip blank
                ++i;
            for(int j = 0; j < ClubMembership.getCustomer().getCustomer().size(); j++){
                String s = ClubMembership.getCustomer().getCustomer().get(j).get(i);
                if(customer[i].equals(s)){
                    for(int k = i; k < MyTable.HEDA_LENGTH; k++){
                        s = ClubMembership.getCustomer().getCustomer().get(j).get(k);
                        if(!customer[k].equals(s) && !customer[k].equals("")){
                            return;
                        }
                    }
                    if(flag) {
                        t.setRowSelectionInterval(j, j); // select multiple rows
                        Rectangle rectangle = t.getCellRect(j,0,true); // jump to the first selected row.
                        t.scrollRectToVisible(rectangle);
                        flag = false;
                    }
                    t.addRowSelectionInterval(j,j);
                }
            }
        }
    }
}
