import java.io.*;
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
    public boolean deleteProfile(String adminID, String lastName) {
        boolean success = false;      //set success to false until the profile is deleted. Then set success to true
        for (int i = 0; i <customerList.size(); i++) {
            CustomerProf customer = customerList.get(i);    //iterate through each person in the customer profile list
            if (customer.getadminID().equals(adminID) && customer.getlastName().equals(lastName)) {
                customerList.remove(i);
                numCustomer--;
                success = true;
                break;
            }
        }
        return success;
    }
    public CustomerProf findProfile(String adminID, String lastName) {
        currentCustomerIndex = -1; //until a customer profile matches, keep index at 1
        for (int i = 0; i < customerList.size(); i++) {
            CustomerProf customer = customerList.get(i);
            if(customer.getadminID().equals(adminID) && customer.getlastName().equals(lastName)) {
                currentCustomerIndex = i;
                break;
            }
        }
        if(currentCustomerIndex == -1) {
            System.out.println("Customer profile is not in the database.");
            return null;
        }
        else{
            return customerList.get(currentCustomerIndex);
        }
    }
    public CustomerProf findFirstProfile() {
        if(numCustomer <= 0) {
            return null;
        }
        else{
            CustomerProf customer = customerList.get(0); //1st customer in the list is at index 0
            return customer;
        }
    }
    public CustomerProf findNextProfile() {
        CustomerProf nextCustomer = customerList.get(currentCustomerIndex);
        currentCustomerIndex++;
        return nextCustomer;
    }
    public void writeAllCustomerProf(String profilesss) throws IOException {
        FileOutputStream output = new FileOutputStream((profilesss));
        ObjectOutputStream objectOutput = new ObjectOutputStream(output);
        objectOutput.writeObject(customerList); //will write out all the profiles from CustomerProf into the destination file
        //objectOutput.close(); //close output stream
    }
    public void initializeDatabase(String PROFILE) throws IOException, ClassNotFoundException{
        FileInputStream input = new FileInputStream(PROFILE);
        ObjectInputStream objectInput = new ObjectInputStream(input);
        customerList = (ArrayList<CustomerProf>)objectInput.readObject(); //writes out all of the Customer Proifles that the user wants entered in from the inpput file to the customer list
    }




}
