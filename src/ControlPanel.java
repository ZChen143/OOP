import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends Panel implements ActionListener {

    private final JButton addNewLine = new JButton("Add");
    private final JButton delete = new JButton("Delete");
    private final JButton search = new JButton("Search");

    public ControlPanel() {
        add(addNewLine);
        addNewLine.addActionListener(this);
        add(delete);
        delete.addActionListener(this);
        add(search);
        search.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTable table = ClubMembership.getTable();
        TableModel model = table.getModel();

        if(e.getSource().equals(addNewLine)){
            new AddingDialog();
            table.updateUI();
        }
        else if(e.getSource().equals(delete)) {
            if(table.getSelectedRow() != -1) {
                int selectOption = JOptionPane.showConfirmDialog(null, "Do you want to delete the chosen customer?", "Warning", JOptionPane.YES_NO_OPTION);
                if (selectOption == JOptionPane.YES_OPTION) {
                    int length = table.getSelectedRows().length;
                    for (int i = 0; i < length; i++)
                        ((DefaultTableModel) model).removeRow(table.getSelectedRow());
                }
            }
        }
        else if(e.getSource().equals(search)){
            SearchingDialog searchingDialog = new SearchingDialog();
        }
    }
}
