import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ClubMembership extends JFrame {

    private final static String FILEPATH = "src/customerlist.csv";

    private final static int XOFFSET = 300;
    private final static int YOFFSET = 200;
    private final static int WIDTH = 1024;
    private final static int HEIGHT = 768;

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

        setBounds(XOFFSET,YOFFSET,WIDTH,HEIGHT);
    }

    @Override
    public void dispose() {

        try {
            TableModel model = ClubMembership.getTable().getModel();
            FileWriter csv = new FileWriter(FILEPATH);

            //System.out.println(model.getValueAt(0,1));
            for (int i = 0; i < model.getRowCount(); i++) {
                if(!(model.getValueAt(i,1) == null || model.getValueAt(i,2) == null)) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        if (model.getValueAt(i, j) == null)
                            csv.write(",");
                        else
                            csv.write(model.getValueAt(i, j).toString() + ",");
                    }
                    csv.write("\n");
                }
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

    public static int getXOffset() {
        return XOFFSET;
    }

    public static int getYOffset() {
        return YOFFSET;
    }
}
