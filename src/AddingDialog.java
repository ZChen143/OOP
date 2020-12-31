import javax.swing.*;

public class AddingDialog extends JDialog {
    public AddingDialog(){
        super(ClubMembership.getFrames()[0],"Add a new line",true);
        setBounds(300,300,500,300);
        setVisible(true);
    }
}
