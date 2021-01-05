import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;


public class Customer {

    private final static int MEMBERSHIPNUMBER = 0;
    private final static int FIRSTNAME = 1;
    private final static int LASTNAME = 2;
    private final static int BIRTHDAY = 3;
    private final static int AGE = 7;

    private final Vector<Vector<String>> customer;

    public Customer() {
        customer = new Vector<>();
    }

    public Vector<Vector<String>> getCustomer() {
        return customer;
    }

    public void addCustomer(String[] customer) {
        Vector<String> v = new Vector<>(Arrays.asList(customer));
        getCustomer().add(v);
    }

    public void createNumNo(String[] customer) {
        String keyInformation;
        if(hasBirthday(customer))
            keyInformation = customer[FIRSTNAME] + customer[LASTNAME] + customer[BIRTHDAY];
        else
            keyInformation = customer[FIRSTNAME] + customer[LASTNAME];
        customer[MEMBERSHIPNUMBER] = Integer.toString(keyInformation.hashCode() & Integer.MAX_VALUE);
    }

    public void calculateAge(String[] customer) {
        String pattern = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if(hasBirthday(customer) && !customer[BIRTHDAY].equals("")) {
            try {
                Date date = simpleDateFormat.parse(customer[BIRTHDAY]);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
            if(lineSplit[MEMBERSHIPNUMBER].equals("") || lineSplit[MEMBERSHIPNUMBER].equals("\uFEFF"))// 65279 ??!!
                createNumNo(lineSplit);

            calculateAge(lineSplit);

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

    public boolean hasBirthday(String[] customer) {
        return (customer.length > BIRTHDAY);
    }
}
