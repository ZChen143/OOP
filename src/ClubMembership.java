import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ClubMembership extends JFrame {

    private final static String FILEPATH = "src/customerlist.csv";

    private final static int X_OFFSET = 300;
    private final static int Y_OFFSET = 100;
    private final static int WIDTH = 1024;
    private final static int HEIGHT = 600;

    private static Customer customer;
    private static MyTable table;

    public static Customer getCustomer() {
        return customer;
    }

    public static MyTable getTable() {
        return table;
    }

    public ClubMembership() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Club Membership");

        customer = new Customer();
        customer.readCsv(FILEPATH);

        table = new MyTable(customer.getCustomer());

        add(new JScrollPane(table), BorderLayout.NORTH);
        add(new ControlPanel(), BorderLayout.SOUTH);

        setBounds(X_OFFSET,Y_OFFSET,WIDTH,HEIGHT);
    }

    @Override
    public void dispose() {

        try {
            TableModel model = ClubMembership.getTable().getModel();
            FileWriter csv = new FileWriter(FILEPATH);

            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i,0) == null)
                    continue;
                else
                   csv.write(model.getValueAt(i, 0).toString());
                for (int j = 1; j < model.getColumnCount(); j++) {
                    if (model.getValueAt(i, j) == null)
                        csv.write(",");
                    else
                        csv.write("," + model.getValueAt(i, j).toString());
                }
                if(i != model.getRowCount()-1)
                    csv.write("\n");
            }
            csv.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        ClubMembership clubMembership = new ClubMembership();
    }

    public static int getXOffset() {
        return X_OFFSET;
    }

    public static int getYOffset() {
        return Y_OFFSET;
    }
}
