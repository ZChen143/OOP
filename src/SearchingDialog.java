import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchingDialog extends MyDialog implements ActionListener {

    public SearchingDialog() {
        super(new JButton("search"), new JButton("cancel"));
        getDueDate().setVisible(false);
        getAGE().setVisible(false);
        getFEE().setVisible(false);
        getLabelDueDate().setVisible(false);
        getLabelAge().setVisible(false);
        getLabelFee().setVisible(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getButton1())){

        }
        else if(e.getSource().equals(getButton2())){

        }
    }

}
