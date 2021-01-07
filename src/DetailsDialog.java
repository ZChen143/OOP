import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class DetailsDialog extends MyDialog{

    public DetailsDialog() {
        super(new JButton("OK"), new JButton("OK"));
        int row = ClubMembership.getTable().getSelectedRow();
        Vector<String> customer = ClubMembership.getCustomer().getCustomer().get(row);
        getTextFirstname().setText(customer.get(1));
        getTextLastname().setText(customer.get(2));
        getTextBirthday().setText(customer.get(3));
        getGenderComboBox().setSelectedIndex(gender(customer.get(4)));
        getTextAddress().setText(customer.get(5));
        getTextTelephone().setText(customer.get(6));
        getTextStartDate().setText(customer.get(8));
        getMembershipComBox().setSelectedIndex(membership(customer.get(9)));

        getButton2().setVisible(false);
        getDueDate().setVisible(true);
        getAGE().setVisible(true);
        getFEE().setVisible(true);
        getLabelDueDate().setVisible(true);
        getLabelAge().setVisible(true);
        getLabelFee().setVisible(true);
        setSize(MyDialog.WIDTH,MyDialog.HEIGHT+50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private int gender(String s){
        if(s == null)
            return 0;
        else if(s.equals("male"))
            return 1;
        else if(s.equals("female"))
            return 2;
        else if(s.equals("others"))
            return 3;
        else if(s.equals("prefer not to disclose"))
            return 4;
        return -1;
    }

    private int membership(String s){
        if(s == null)
            return 0;
        else if(s.equals("individual"))
            return 1;
        else if(s.equals("family"))
            return 2;
        else if(s.equals("visitor"))
            return 3;
        return -1;

    }
}
