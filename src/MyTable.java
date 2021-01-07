import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

public class MyTable extends JTable{

    private static final Vector<String> columnNames = new Vector<>(Arrays.asList("Membership NO.", "First Name", "Last Name", "Date of Birth", "Gender", "Address", "Telephone", "Age", "Start date","Due date"));
    public static final int HEADER_LENGTH = columnNames.size();
    private DefaultTableModel tableModel;

    public MyTable(Vector<Vector<String>> data){
        tableModel = new DefaultTableModel(data, columnNames);
        setModel(tableModel);
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
