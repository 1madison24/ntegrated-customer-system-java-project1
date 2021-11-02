import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
import CustomerProf.CustomerProf;
/* Object serialization = object can be represented as a sequence of bytes that includes
    the object's data, info about the object's type, and the types of data stores in the object
   After serialized object is written into a file, it can be read from that file and
    deserialized (i.e. the type info and bytes representing the object + its data
                   --> used to recreate the object in memory
 */

//Maintains a collection of CustomerProfs for all customers that have used ICS in the past or present
public class CustomerProfDB implements Serializable{
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
        //checks if the customer profile is in the database or not
        if(currentCustomerIndex == -1) {
            System.out.println("Customer profile is not in the database.");
            return null;
        }
        else{
            return customerList.get(currentCustomerIndex);
        }
    }
    public CustomerProf findFirstProfile() {
        if(numCustomer <= 0) { //if there are no profiles in the database, then there will be no first profile
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

    public void writeAllCustomerProf(String fileName) throws IOException{
        // create FileWriter for file w/ file path newName (will be clearing the file and rewriting it each time method is called)
        FileWriter writer = new FileWriter(fileName);
        for (CustomerProf customerProf: customerList) { // loop through all customers in the customerList
            writer.write(customerProf.getadminID() + " " +
                    customerProf.getfirstName() + " " +
                    customerProf.getlastName() + " " +
                    customerProf.getphone() + " " +
                    customerProf.getAddress() + " " +
                    customerProf.getincome() + " " +
                    customerProf.getstatus() + " " +
                    customerProf.getuse() + " " +
                    customerProf.getvehicleInfo().getModel() + " " +
                    customerProf.getvehicleInfo().getYear() + " " +
                    customerProf.getvehicleInfo().getType() + " " +
                    customerProf.getvehicleInfo().getMethod() + " " + "\n"
                );
        }
        writer.close();      // close FileWriter
    }

    public void initializeDatabase(String PROFILE) throws IOException, ClassNotFoundException{
        FileInputStream input = new FileInputStream(PROFILE);
        ObjectInputStream objectInput = new ObjectInputStream(input);
        customerList = (ArrayList<CustomerProf>)objectInput.readObject(); //writes out all Customer Profiles that the user wants to enter in from the input file to the customer list
    }
}
