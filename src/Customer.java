import java.io.*;
import java.util.Arrays;
import java.util.Vector;


public class Customer {

    private final Vector<Vector<String>> customer;

    public Customer() {
        customer = new Vector<>();
    }

    public Vector<Vector<String>> getCustomer() {
        return customer;
    }

    public void addCustomer(String[] s) {
        Vector<String> v = new Vector<>(Arrays.asList(s));
        getCustomer().add(v);
    }

    public void createNumNo() {
        for(int i = 0; i < customer.size(); i++){
            String s = customer.get(i).get(1) + customer.get(i).get(2) + customer.get(i).get(3);
            System.out.println(s);
        }
    }

    public void readCsv(String filePath) {
        String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String line = "";
        String[] lineSplit;
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
                assert br != null;
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            lineSplit = line.split(csvSplitBy);

            //Create Membership Numbers by hashcode if it's null.
            if(lineSplit[0] == null){

            }

            if(!isEqual(lineSplit)) {
                for (String s : lineSplit) {
                    tmp.add(s);
                    v = (Vector<String>) tmp.clone();
                }
                customer.add(v);
                tmp.clear();
            }
        }
    }

    public boolean isEqual(String[] lineSplit) {
        if (lineSplit.length >= 4 && customer.lastElement().size() >= 4){
            Vector<String> v = customer.lastElement();
            return (lineSplit[1].equals(v.get(1)) && lineSplit[2].equals(v.get(2)) && lineSplit[3].equals(v.get(3)));
        }
        return false;
    }
}
