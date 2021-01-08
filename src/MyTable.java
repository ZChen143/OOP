import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

public class MyTable extends JTable{

    private static final Vector<String> columnNames = new Vector<>(Arrays.asList("Membership NO.", "First Name", "Last Name", "Date of Birth", "Gender", "Address", "Telephone", "Age", "Start date","Due date","Membership","Fee"));
    public static final int HEDA_LENGTH = columnNames.size();
    private DefaultTableModel tableModel;

    public MyTable(Vector<Vector<String>> data){
        tableModel = new DefaultTableModel(data, columnNames);
        setModel(tableModel);

        TableColumn age = getColumnModel().getColumn(7);
        TableColumn membership = getColumnModel().getColumn(10);
        TableColumn fee = getColumnModel().getColumn(11);
        age.setMinWidth(0);
        age.setMaxWidth(0);
        age.setPreferredWidth(0);
        membership.setMaxWidth(0);
        membership.setMinWidth(0);
        membership.setPreferredWidth(0);
        fee.setMaxWidth(0);
        fee.setMinWidth(0);
        fee.setPreferredWidth(0);

        setBounds(20,30,200,300);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double click
                    new DetailsDialog();
                }
            }
        });
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public Vector<String> getColumnNames() { return columnNames; }

}
