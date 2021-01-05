import java.awt.*;
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

    public void createNumNo(String[] information) {
        String keyInformation;
        if(information[BIRTHDAY] != null )
            keyInformation = information[FIRSTNAME] + information[LASTNAME] + information[BIRTHDAY];
        else
            keyInformation = information[FIRSTNAME] + information[LASTNAME];
        information[MEMBERSHIPNUMBER] = Integer.toString(keyInformation.hashCode() & Integer.MAX_VALUE);
    }

    public void calculateAge(String[] information) {
        String pattern = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if(information[BIRTHDAY] != null && information[BIRTHDAY].equals("")) {
            try {
                Date date = simpleDateFormat.parse(information[BIRTHDAY]);
                System.out.println(information[FIRSTNAME]);
                System.out.println(date);
            } catch (ParseException e) {
            }
        }
    }

    public void readCsv(String filePath) {
        String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String line = "";
        String[] lineSplit;
        Vector<String> v = new Vector<>();
        Vector<String> tmp = new Vector<>();
        int n = 0;

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

            String[] information = new String[MyTable.HEADER_LENGTH];
            lineSplit = line.split(csvSplitBy);
            for(int i = 0; i < lineSplit.length; i++)
                information[i] = lineSplit[i];

            //Create Membership Numbers by hashcode if it's null.
            if(information[MEMBERSHIPNUMBER].equals("") || information[MEMBERSHIPNUMBER].equals("\uFEFF"))// 65279 ??!!
                createNumNo(information);

            n += 1;
            System.out.println(n);
            calculateAge(information);

            if(!isEqual(information)) {
                for (String s : information) {
                    tmp.add(s);
                    v = (Vector<String>) tmp.clone();
                }
                customer.add(v);
                tmp.clear();
            }
        }
    }

    public boolean isEqual(String[] information) {
        if(customer.size() != 0) {
            Vector<String> v = customer.lastElement();
            if (information[BIRTHDAY] != null && customer.lastElement().get(BIRTHDAY) !=null)
                return (information[FIRSTNAME].equals(v.get(FIRSTNAME)) && information[LASTNAME].equals(v.get(LASTNAME)) && information[BIRTHDAY].equals(v.get(BIRTHDAY)));
        }
        return false;
    }
}
