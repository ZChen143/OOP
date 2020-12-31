import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends Panel implements ActionListener {

    private JButton addNewLine = new JButton("Add new line");
    private JButton delete = new JButton("Delete");
    private JButton search = new JButton("Search");
    private JButton update = new JButton("Update");

    public ControlPanel() {
        add(addNewLine);
        addNewLine.addActionListener(this);
        add(delete);
        delete.addActionListener(this);
        add(search);
        search.addActionListener(this);
        add(update);
        update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Customer customer = ClubMembership.getCustomer();
        Table table = ClubMembership.getTable();
        TableModel model = table.getModel();

        if(e.getSource().equals(addNewLine)){
            customer.addCustomer(new String[]{null,null,null,null,null,null,null,null,null});
            table.updateUI();
            Rectangle rectangle = table.getCellRect(table.getRowCount()-1,0,true);
            table.scrollRectToVisible(rectangle);
        }
        else if(e.getSource().equals(delete)){
            int length = table.getSelectedRows().length;
            for(int i = 0; i < length ; i++)
                ((DefaultTableModel)model).removeRow(table.getSelectedRow());
        }
        else if(e.getSource().equals(search)){
        }
        else if(e.getSource().equals(update)){
            if(table.getCellEditor() != null) {
                table.getCellEditor().stopCellEditing();
                int r = model.getRowCount();
                int c = model.getColumnCount();
                ((AbstractTableModel) model).fireTableCellUpdated(r, c);
            }
        }
    }
}
