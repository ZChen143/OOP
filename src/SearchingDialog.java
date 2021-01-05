import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SearchingDialog extends MyDialog implements ActionListener {

    public SearchingDialog() {
        super(new JButton("search"), new JButton("cancel"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getButton1())){
        }
        else if(e.getSource().equals(getButton2())){

        }
    }
}
