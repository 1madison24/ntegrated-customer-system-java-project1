import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

import CustomerProf.CustomerProf;
import VehicleInfo.VehicleInfo;


//Maintains a collection of CustomerProfs for all customers that have used ICS in the past or present
public class CustomerProfDB {
    //initialize variables
    int numCustomer;
    int currentCustomerIndex;
    String fileName;
    ArrayList<CustomerProf> customerList;

    //the constructor
    public CustomerProfDB(String profile) {
        fileName = profile;
        numCustomer = 0;
        currentCustomerIndex = 0;
        customerList = new ArrayList<CustomerProf>();
    }

    public void insertNewProfile(CustomerProf cusProfile) {
        try{
            CustomerProf existingProf = findProfile(cusProfile.getadminID(), cusProfile.getlastName());   // checks if the prof exists in the customerList with the same adminId and lastName
            // if no exceptions are caught, the prof exists so update its info to the inputted customerprof (prof)
            existingProf.UpdatefirstName(cusProfile.getfirstName());
            existingProf.UpdatelastName(cusProfile.getlastName());
            existingProf.UpdateAddress(cusProfile.getAddress());
            existingProf.Updatephone(cusProfile.getphone());
            existingProf.Updateincome(cusProfile.getincome());
            existingProf.Updatestatus(cusProfile.getstatus());
            existingProf.UpdatevehicleInfo(cusProfile.getvehicleInfo());
        }
        catch(IllegalArgumentException e){
            customerList.add(cusProfile);
            numCustomer++;
        }
    }

    //deletes the profile that the user wants deleted
    public boolean deleteProfile(String adminID, String lastName) {
        numCustomer--; //now the number of customers has decreased by 1
        return customerList.remove(findProfile(adminID, lastName));
    }

    //finds the customer profile based on user provided adminID and last name
    public CustomerProf findProfile(String adminID, String lastName) {
        for(CustomerProf customer: customerList){
            if(customer.getadminID().equals(adminID) && customer.getlastName().equals(lastName)){
                currentCustomerIndex = customerList.indexOf(customer);
                return customer;
            }
        }
        throw new IllegalArgumentException("Unable to find customer"); //if the adminID or last name does not match any customer profile
    }

    public CustomerProf findFirstProfile() {
        if (numCustomer <= 0) { //if there are no profiles in the database, then there will be no first profile
            return null;
        } else {
            CustomerProf customer = customerList.get(0); //1st customer in the list is at index 0
            return customer;
        }
    }

    //for when someone wants to find the next profile in the customerList
    public CustomerProf findNextProfile() {
        currentCustomerIndex++;
        return customerList.get(currentCustomerIndex);
    }

    public void writeAllCustomerProf(String fileName) throws IOException {
        // create FileWriter for file w/ file path newName (will be clearing the file and rewriting it each time method is called)
        FileWriter writer = new FileWriter(fileName);
        for (CustomerProf customerProf : customerList) { // loop through all customers in the customerList
            writer.write(customerProf.getadminID()  + "\n" +
                    customerProf.getfirstName() +  "\n" +
                    customerProf.getlastName() +  "\n" +
                    customerProf.getphone() + "\n" +
                    customerProf.getAddress() +  "\n" +
                    customerProf.getincome() + "\n" +
                    customerProf.getstatus() + "\n" +
                    customerProf.getuse() + "\n" +
                    customerProf.getvehicleInfo().getModel() +  "\n" +
                    customerProf.getvehicleInfo().getYear() +  "\n" +
                    customerProf.getvehicleInfo().getType() +  "\n" +
                    customerProf.getvehicleInfo().getMethod() + "\n"
            );
        }
        writer.close();      // close FileWriter
    }

    //this is important for obtaining the customer list
    //this method will be used in other classes to check if the customer exists in the customer list
    public ArrayList<CustomerProf> getCustomerList() {
        return customerList;
    }

    //for initializing the database which will be super importance for the CustomerProfInterface class
    public void initializeDatabase(String NewFile) throws FileNotFoundException, NoSuchElementException {
        fileName = NewFile; //takes in the file
        File thisFile = new File(fileName);
        Scanner sc = new Scanner(thisFile);
        while (sc.hasNextLine()) {
            CustomerProf newProfile = new CustomerProf(
                    (sc.nextLine()), //adminID
                    (sc.nextLine()), //fist name
                    (sc.nextLine()), // last name
                    (sc.nextLine()), //phone
                    (sc.nextLine()), //address
                    Float.parseFloat((sc.nextLine())), //income
                    (sc.nextLine()), //status
                    (sc.nextLine()), //use
                    new VehicleInfo(
                            (sc.nextLine()), //model
                            (sc.nextLine()), //year
                            (sc.nextLine()), //type
                            (sc.nextLine())) //method
            );
            insertNewProfile(newProfile);
        }
        sc.close();
    }

    /*
    public void initializeDatabase(String PROFILE) throws IOException, ClassNotFoundException{
        FileInputStream input = new FileInputStream(PROFILE);
        ObjectInputStream objectInput = new ObjectInputStream(input);
        customerList = (ArrayList<CustomerProf>)objectInput.readObject(); //writes out all Customer Profiles that the user wants to enter in from the input file to the customer list
    }
}

     */
//used for testing
    public static void main(String[] args) {

    }
}

