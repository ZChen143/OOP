import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyTextField extends JTextField implements FocusListener {

    private String hint;
    private boolean showingHint;

    public MyTextField(String hint) {
        super(hint);
        setSize(100,10);
        setForeground(Color.gray);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(getText().isEmpty()) {
            setForeground(Color.BLACK);
            super.setText("");
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getText().isEmpty()) {
            setForeground(Color.gray);
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    @Override
    public void setEditable(boolean b) {
        super.setEditable(b);
    }

    @Override
    public void setText(String t) {
        super.setText(t);
        hint = t;
        showingHint = false;
        setForeground(Color.BLACK);
        removeFocusListener(this);
    }

}
