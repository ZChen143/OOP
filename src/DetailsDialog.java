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
        getLabelAge().setText(customer.get(7));
        getTextStartDate().setText(customer.get(8));
        getMembershipComBox().setSelectedIndex(membership(customer.get(10)));
        getLabelDueDate().setText(customer.get(9));
        getLabelFee().setText(customer.get(11));

        getButton2().setVisible(false);
        getDueDate().setVisible(true);
        getAGE().setVisible(true);
        getFEE().setVisible(true);
        getLabelDueDate().setVisible(true);
        getLabelAge().setVisible(true);
        getLabelFee().setVisible(true);
        getMembershipNumber().setVisible(false);
        getTextMemNO().setVisible(false);

        getTextFirstname().setEditable(false);
        getTextLastname().setEditable(false);
        getTextBirthday().setEditable(false);
        getGenderComboBox().setEditable(false);
        getTextAddress().setEditable(false);
        getTextTelephone().setEditable(false);
        getTextStartDate().setEditable(false);
        getMembershipComBox().setEditable(false);


        // It's so stupid to use these components like this and I have no idea to modify.
        // Maybe you can try to use getComponents() and don't be so stupid like me XD
        setSize(MyDialog.WIDTH,MyDialog.HEIGHT+50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("OK"))
            dispose();
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
        else if(s.equals("individual/year"))
            return 1;
        else if(s.equals("individual/month"))
            return 2;
        else if(s.equals("family/year"))
            return 3;
        else if(s.equals("family/month"))
            return 4;
        else if(s.equals("visitor"))
            return 5;
        return -1;

    }
}
