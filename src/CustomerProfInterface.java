import java.io.*;
import java.util.Scanner;
import java.io.Serializable;
import CustomerProf.CustomerProf;
/* Object serialization = object can be represented as a sequence of bytes that includes
    the object's data, info about the object's type, and the types of data stores in the object
   After serialized object is written into a file, it can be read from that file and
    deserialized (i.e. the type info and bytes representing the object + its data
                   --> used to recreate the object in memory
 */

public class CustomerProfInterface implements Serializable{
    static String filename;
    CustomerProfDB database = new CustomerProfDB("dbFile"); //create CustomerProfDB object for initializing/writing
    private String adminID; //stores adminID here after menu selection
    CustomerProf CustomerProf;

    public void getUserChoice() throws IOException{
        //prompt user select a menu option
        System.out.println("Select menu option: ");
        Scanner scan = new Scanner(System.in);
        int input;
        boolean variable = true;
        while(variable) {
            System.out.println("1. Find a Customer's Profile");
            System.out.println("2. Display all Customer Profiles in the Database");
            System.out.println("3. Modify a Customer's Profile");
            System.out.println("4. Create a new Customer's Profile");
            System.out.println("5. Delete a Customer's Profile");
            System.out.println("6. Initialize Database");
            System.out.println("7. Write to the Database");
            System.out.println("8. Quit");
            input = Integer.parseInt(scan.nextLine()); //make sure input is integer and matches w/ a valid menu selection
            //adminID entered with menu options
            System.out.println("Enter adminID: ");
            adminID = scan.nextLine();

            if (input == 1) {
                findCustomerProf();
            }
            if(input == 2) {
                displayAllCustomerProf();
            }
            if(input == 3) {
                updateCustomerProf();
            }
            if(input == 4){
                createNewCustomerProf();
            }
            if(input == 5){
                deleteCustomerProf();
            }
            if(input == 6){
                initDB(); //might not need if we are initialzing the database at the very beginning
            }
            if(input == 7){
                writeToDB();
            }
            if(input == 8){
                System.out.println("Quitting....");
                variable = false;
            }
        }
    }
    void deleteCustomerProf() {
        //let's find the customer's profile based on adminID and last name
        Scanner inputadminID = new Scanner(System.in);
        System.out.println("Enter adminID: ");
        String adminID = inputadminID.nextLine();
        Scanner findScan = new Scanner(System.in);
        System.out.println("Enter customer's last name: ");
        String lastName = findScan.nextLine();

        //make deletion a boolean
        //if deletion is true, then deleted  -> else, custprof not found
        boolean deletion = database.deleteProfile(adminID, lastName);
        if(deletion) {
            System.out.println("The customer profile has been deleted.");
        }
        else {
            System.out.println("Customer profile not found");
        }
    }
    void findCustomerProf() {
        //let's find the customer's profile based on adminID and last name
        Scanner inputadminID = new Scanner(System.in);
        System.out.println("Enter adminID: ");
        String adminID = inputadminID.nextLine();
        Scanner findScan = new Scanner(System.in);
        System.out.println("Enter customer's last name: ");
        String lastName = findScan.nextLine();

        //if profile does not exist --> return null
        //if not found --> findProfile returns null
        if(database.findProfile(adminID, lastName) == null) {
            System.out.println("Customer profile not in database");
        }
        else {
            displayCustomerProf(database.findProfile(adminID, lastName));
        }
    }
    void updateCustomerProf() {

    }
    void displayCustomerProf(CustomerProf customerProf) {
        //print out everything in the Customer's Profile
        System.out.println("Admin ID: " + customerProf.getadminID());
        System.out.println("Customer's First Name: " + customerProf.getfirstName());
        System.out.println("Customer's Last Name: " + customerProf.getlastName());
        System.out.println("Customer's Home Phone Number: " + customerProf.getphone());
        System.out.println("Customer's Home Address:" + customerProf.getAddress());
        System.out.println("Household income: " + customerProf.getincome());
        System.out.println("Current status of the customer: " + customerProf.getstatus());
        System.out.println("Use of the vehicle: " + customerProf.getuse());

        System.out.println("Customer's Vehicle Information");
        System.out.println("Name of vehicle model:  " + customerProf.getvehicleInfo().getModel());
        System.out.println("Year in which the vehicle was manufactured: " + customerProf.getvehicleInfo().getYear());
        System.out.println("Type of vehicle: " + customerProf.getvehicleInfo().getType());
        System.out.println("How the vehicle was acquired: " + customerProf.getvehicleInfo().getMethod());
    }
    void displayAllCustomerProf() {
        Scanner inputadminID = new Scanner(System.in);
        System.out.println("Enter adminID: ");
        String adminID = inputadminID.nextLine();
        for(int i = 0; i < database.customerList.size(); i++) {
            CustomerProf TempCustomerProf  = database.customerList.get(i);
            if(TempCustomerProf.getadminID().equals(adminID)) {
                displayCustomerProf(TempCustomerProf);
            }
        }
    }
    void writeToDB() throws IOException {


    }
    void createNewCustomerProf() {

    }
    void createNewVehicleInfo() {

    }
}
