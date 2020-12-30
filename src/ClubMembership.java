import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClubMembership extends JFrame {

    private final static String FILEPATH = "src/customerlist.csv";

    private static Customer customer;
    private static Table table;

    public static Customer getCustomer() {
        return customer;
    }

    public static Table getTable() {
        return table;
    }

    public ClubMembership() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Club Membership");

        customer = new Customer();
        customer.readCsv(FILEPATH);
        table = new Table(customer.getCustomer());

        add(new JScrollPane(table), BorderLayout.NORTH);
        add(new ControlPanel(), BorderLayout.SOUTH);

        setSize(1024, 768);
    }

    @Override
    public void dispose() {
        try {
            TableModel model = ClubMembership.getTable().getModel();
            FileWriter csv = new FileWriter(new File(FILEPATH));

            //System.out.println(model.getValueAt(0,1));
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if (model.getValueAt(i, j) == null)
                        csv.write(",");
                    else
                        csv.write(model.getValueAt(i, j).toString() + ",");
                }
                csv.write("\n");
            }
            csv.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        ClubMembership c = new ClubMembership();
    }
}
