import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public class Customer {

    private final static int MEMBERSHIP_NUMBER = 0;
    private final static int FIRSTNAME = 1;
    private final static int LASTNAME = 2;
    private final static int BIRTHDAY = 3;
    private final static int AGE = 7;
    private final static int START_DATE = 8;
    private final static int DUE_DATE = 9;
    private final static int MEMBERSHIP = 10;
    private final static int FEE = 11;


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
        information[MEMBERSHIP_NUMBER] = Integer.toString(keyInformation.hashCode() & Integer.MAX_VALUE);
    }

    public void calculateAge(String[] information) {
        String pattern = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (information[BIRTHDAY] != null)
            if (!information[BIRTHDAY].equals("")) {
                try {
                    String[] birthday = simpleDateFormat.parse(information[BIRTHDAY]).toString().split(" ");
                    String[] currentDate = new Date().toString().split(" ");
                    information[AGE] = String.valueOf(Integer.parseInt(currentDate[5]) - Integer.parseInt(birthday[5]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
    }

    public void calculateDueDate(String[] information) {
        int fee = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        Date date = null;
        try {
            date = format.parse(information[START_DATE]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        assert date != null;
        cal.setTime(date);

        switch (information[MEMBERSHIP]) {
            case "individual/year" -> {
                cal.add(Calendar.YEAR, 1);
                fee = 36 * 12;
            }
            case "individual/month" -> {
                cal.add(Calendar.MONTH, 1);
                fee = 36;
            }
            case "family/year" -> {
                cal.add(Calendar.YEAR, 1);
                fee = 60 * 12;
            }
            case "family/month" -> {
                cal.add(Calendar.MONTH, 1);
                fee = 60;
            }
            case "visitor" -> {
                cal.add(Calendar.DATE, 1);
                fee = 3;
            }
            case "" -> {
                information[DUE_DATE] = "";
                information[FEE] = "";
            }
        }

        information[DUE_DATE] = format.format(cal.getTime());
        information[FEE] = Integer.toString(fee);
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

            String[] information = new String[MyTable.HEDA_LENGTH];
            lineSplit = line.split(csvSplitBy);
            System.arraycopy(lineSplit, 0, information, 0, lineSplit.length);

            //Create Membership Numbers by hashcode if it's null.
            if(information[MEMBERSHIP_NUMBER].equals("") || information[MEMBERSHIP_NUMBER].equals("\uFEFF"))// \65279 in JS,python, \uFEFF in C/C++,JAVA,C#.
                createNumNo(information);

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

    // This function can only judge the customer who has name and birthday.
    // The customers with the same name and don't have birthday assume as different people.
    // One example is Hathaway Anne.
    // Thus, the problem is how to give them different membership number.
    // Due to I created the membership number by String.hashcode().
    public boolean isEqual(String[] information) {
        if(customer.size() != 0) {
            Vector<String> v = customer.lastElement();
            if (information[BIRTHDAY] != null && customer.lastElement().get(BIRTHDAY) !=null)
                return (information[FIRSTNAME].equals(v.get(FIRSTNAME)) && information[LASTNAME].equals(v.get(LASTNAME)) && information[BIRTHDAY].equals(v.get(BIRTHDAY)));
        }
        return false;
    }
}
