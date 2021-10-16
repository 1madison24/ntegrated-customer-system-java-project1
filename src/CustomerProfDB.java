import java.io.IOException;
import java.util.ArrayList;

//Maintains a collection of CustomerProfs for all customers that have used ICS in the past or present
public class CustomerProfDB {
    //initialize variables
    int numCustomer;
    int currentCustomerIndex;
    String fileName;
    ArrayList<CustomerProf> customerList = new ArrayList<CustomerProf>();

    public CustomerProfDB(String profile) {
        fileName = profile;
    }
    public void insertNewProfile(CustomerProf cusProfile) {
        customerList.add(cusProfile); //insert the new profile into the array
        numCustomer++;                //increment the number of customers by 1
    }
    public boolean deletePofile(String adminID, String lastName) {
        boolean success = false;      //set success to false until the profile is deleted. Then set success to true
        for (int i = 0; i <customerList.size(); i++) {
            CustomerProf customer = customerList.get(i);    //iterate through each person in the customer profile list

            //now if the adminID == last name, the matching customerprofile has been found
            if((customer.getadminID().equals(adminID)) && (customer.getlastName().equals(lastName))) {
                currentCustomerIndex = i;
                break;
            }
        }
        if(currentCustomerIndex == -1) {
            System.out.println("No such customer in the database.");
            return null;
        }
        else{ //return that matching customer profile
            return customerList.get(currentCustomerIndex);
        }

    }
    public CustomerProf findProfile(String adminID, String lastName) {

    }
    public CustomerProf findFirstProfile() {

    }
    public CustomerProf findNextProfile() {

    }
    public void writeAllCustomerProf(String profilesss) throws IOException {

    }
    public void initializeDatabase(String PROFILE) throws IOException, ClassNotFoundException{

    }




}
