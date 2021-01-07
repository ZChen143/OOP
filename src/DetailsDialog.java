import javax.swing.*;
import java.awt.event.ActionEvent;

public class DetailsDialog extends MyDialog{

    public DetailsDialog() {
        super(new JButton("OK"), new JButton("OK"));
        setTextFirstname("ew");
        setTextLastname("Hd");
        getButton2().setVisible(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
