import java.io.*;
import java.util.Arrays;
import java.util.Vector;


public class Customer {

    private Vector<Vector<String>> customer;

    public Customer() {
        customer = new Vector<Vector<String>>();
    }

    public Vector<Vector<String>> getCustomer() {
        return customer;
    }

    public void addCustomer(String[] s) {
        Vector<String> v = new Vector<>(Arrays.asList(s));
        getCustomer().add(v);
    }

    public void readCsv(String filePath) {
        String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String line = "";
        String lineSplit[] = null;
        Vector<String> v = new Vector<>();
        Vector<String> tmp = new Vector<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            lineSplit = line.split(csvSplitBy);

            for (int i = 0; i < lineSplit.length; i++){
                tmp.add(lineSplit[i]);
                v = (Vector<String>) tmp.clone();
            }
            customer.add(v);
            tmp.clear();
        }
    }
}
