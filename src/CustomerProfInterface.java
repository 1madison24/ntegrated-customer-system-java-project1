import java.io.*;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.io.Serializable;
import CustomerProf.CustomerProf;
import VehicleInfo.VehicleInfo;
import java.io.IOException;


/* Encapsulates the functionality for a menu driven interface, with each of
its methods containing the required code for receiving inputs from the user and displaying results. Note
that this interface is intended for use by various types of administrative personnel to access, create,
change, and manipulate entries in the CustomerProfDB
 */
public class CustomerProfInterface{
    String fileName;
    CustomerProfDB database;
    private String adminID; //stores adminID here after menu selection


    //The Constructor
    /*
    Accepts the name of the file which acts as the database for the user interface
    Calls the CustomerProfDB to:
        - initialize the database
        - read from the database file
    All profiles in memory are written to the database file
     */
    public CustomerProfInterface(String filename) {
        fileName = filename;
        database = new CustomerProfDB(filename);
    }



    public void initDB(){
        //Scanner initialize = new Scanner(System.in);

        while(true) {
            // System.out.print("Enter a file path to be used: ");
            try {
                database.initializeDatabase(fileName);
                System.out.println("Database initialization was successful.");
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Error with initializing database. File not found.");
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Error with initializing database.");
                break;
            }
        }
    }




    /*
       Presents user w/ menu of options where each selection is recorded and the appropriate method is called
     */
    public void getUserChoice(){
        //prompt user select a menu option
        initDB();
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
            System.out.println("6. Write to the Database");
            System.out.println("7. Quit");
            input = Integer.parseInt(scan.nextLine()); //make sure input is integer and matches w/ a valid menu selection
            //adminID entered with menu options

            if (input == 1) {
                System.out.println("Enter adminID: ");
                adminID = scan.nextLine();
                findCustomerProf();
            }
            if(input == 2) {
                System.out.println("Enter adminID: ");
                adminID = scan.nextLine();
                displayAllCustomerProf();
            }
            if(input == 3) {
                System.out.println("Enter adminID: ");
                adminID = scan.nextLine();
                updateCustomerProf();
            }
            if(input == 4){
                System.out.println("Enter adminID: ");
                adminID = scan.nextLine();
                createNewCustomerProf();
            }
            if(input == 5){
                System.out.println("Enter adminID: ");
                adminID = scan.nextLine();
                deleteCustomerProf();
            }
            if(input == 6){
                writeToDB();
            }
            if(input == 7){
                System.out.println("Quitting....");
                variable = false;
            }
        }
        scan.close();
    }


    //Will delete the customer's profile when provided that profile's adminID and last name
    void deleteCustomerProf() {
        //let's find the customer's profile based on adminID and last name
        Scanner inputadminID = new Scanner(System.in);
        System.out.println("Enter customer's adminID: ");
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

    //CustomerProf Modifications
    /*
    User can modify a profile by selecting which part of the profile they would
    like to change.
     */
    void updateCustomerProf() {
        //first ask for profile's adminID and last name
        Scanner inputadminID = new Scanner(System.in);//scanner for getting the user's input
        System.out.println("Enter adminID: ");
        String adminID = inputadminID.nextLine();

        Scanner updateScanner = new Scanner(System.in);//scanner for user input
        System.out.println("Enter last name: ");
        String lastName = updateScanner.nextLine();

        //if the user inputs are not found in the database, then let the user know that the profile is not found in the database
        CustomerProf updateProf = database.findProfile(adminID, lastName);
        if (updateProf == null) {
            System.out.println("Profile not in database");
            return;
        }
        int input;
        System.out.println("What would you like to change: ");
        do {
            System.out.println("1: First Name");
            System.out.println("2: Last Name");
            System.out.println("3: Address");
            System.out.println("4: Phone");
            System.out.println("5: Income");
            System.out.println("6: Status");
            System.out.println("7: Use");
            System.out.println("8: Model");
            System.out.println("9: Year");
            System.out.println("10: Type");
            System.out.println("11: Method");
            try {
                input = Integer.parseInt(updateScanner.nextLine());
                if (input >= 0 && input <= 11){
                    break;
                } else {
                    System.out.println("Please enter a valid Input");

                }
            } catch (Exception e){
                System.out.println("Please enter a valid input:");
            }
        } while (true);
        if (input == 1){
            System.out.println("Please enter a new First Name: ");
            String newFirst = updateScanner.nextLine();
            updateProf.UpdatefirstName(newFirst);
        }
        if (input == 2) {
            System.out.println("Please enter a new Last Name: ");
            String newLast = updateScanner.nextLine();
            updateProf.UpdatelastName(newLast);
        }
        if (input == 3) {
            System.out.println("Please enter a new Address: ");
            String updatedAddress = updateScanner.nextLine();
            updateProf.UpdateAddress(updatedAddress);
        }
        if (input == 4) {
            System.out.println("Please enter a new Phone Number: ");
            String updatedPhone = updateScanner.nextLine();
            updateProf.Updatephone(updatedPhone);
        }
        if (input == 5) {
            System.out.println("Please enter new Income: ");
            String updatedValue = updateScanner.nextLine();

            //see if the new copay user has inputted is a valid number
            boolean check = false;
            float newIncome = 0;
            while(!(check)) {
                try {
                    newIncome = Float.parseFloat(updatedValue);
                    check = true;
                }
                catch (Exception NumberFormatException) {
                    //ensures that the input
                    System.out.println("Please re-enter a valid number for Income");
                    updatedValue = updateScanner.nextLine();
                }
            }
            updateProf.Updateincome(newIncome);
        }
        if (input == 6) {
            //Current status of the customer -- "Active" or "Inactive"
            System.out.println("Please enter new Status: ");
            String updatedStatus = updateScanner.nextLine();
            //while loop checks that the user is entering the correct attribute value
            while(!((updatedStatus.equals("Active")) || (updatedStatus.equals("Inactive")))) {
                System.out.println("Please enter \"Active\" or \"Inactive\"");
                updatedStatus = updateScanner.nextLine();
            }
            updateProf.Updatestatus(updatedStatus);
        }
        if (input == 7) {
            //Use of the vehicle -- "Business" or "Personal" or "Both"
            System.out.println("Please enter new Use: ");
            String newUse = updateScanner.nextLine();

            //Check if the inputted use is Business, Personal, or Both. if none, ask user again
            while (!((newUse.equals("Business")) || (newUse.equals("Personal")) || (newUse.equals("Both")))) {
                System.out.println("Please enter \"Business\" or \"Personal\" or \"Both\"");
                newUse = updateScanner.nextLine();
            }
            updateProf.UpdateUse(newUse);
        }
        /*
        Options 8 through 11 is where the customer is able to modify attributes
        from the VehicleInfo class. The user will be asked to select which attribute
        that they want to change and then prompted for a new attribute value
         */
        if (input == 8) {
            System.out.println("Please enter new Model: ");
            String newModel = updateScanner.nextLine();
            updateProf.getvehicleInfo().updateModel(newModel);
        }
        if (input == 9) {
            System.out.println("Please enter new Year: ");
            String updatedValue = updateScanner.nextLine();
            updateProf.getvehicleInfo().updateYear(updatedValue);
        }
        if (input == 10) {
            //Type of vehicle -- sedan, hatchback, luxury, sport, other
            System.out.println("Please enter new Type: ");
            String updatedType = updateScanner.nextLine();

            //check that th user input is valid
            while(!((updatedType.equals("sedan")) || (updatedType.equals("hatchback")) || (updatedType.equals("luxury")) || (updatedType.equals("sport")) || (updatedType.equals("other")))) {
                updatedType = updateScanner.nextLine();
            }
            updateProf.getvehicleInfo().updateType(updatedType);
        }
        if (input == 11) {
            //how vehicle was acquired -- new, certified, pre-owned, used, other
            System.out.println("Please enter new Method: ");
            String updatedMeth = updateScanner.nextLine();

            //check that the input is valid
            while(!((updatedMeth.equals("new")) || (updatedMeth.equals("certified")) || (updatedMeth.equals("pre-owned")) || (updatedMeth.equals("used")) || (updatedMeth.equals("other")))) {
                System.out.println("Please enter \"new\", \"certified\", \"pre-owned\", \"used\" or \"other\"");
                updatedMeth = updateScanner.nextLine();
            }
            updateProf.getvehicleInfo().updateMethod(updatedMeth);
        }
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

    //a helper function
    public boolean DoesCustomerProfExist(String adminID) {
        //will loop through the customer profiles within the CustomerList to see if the customer profile does exist
        for(CustomerProf customerProf: database.getCustomerList()) {
            if(customerProf.getadminID().equals(adminID)) { //if adminID matches the adminID of a customerProf
                return true;
            }
        }
        return false; // if no customer prof matched that adminID, then false
    }


    /*
   Displays all the customer profiles in the ICS provided the adminID
     */
    void displayAllCustomerProf() {
        /* The old code
        Scanner inputadminID = new Scanner(System.in); //for user input
        System.out.println("Enter adminID: "); //prompts fo the adminID
        String adminID = inputadminID.nextLine();

        //prints out the corresponding profiles for that adminID onto the screen one after another
        for(int i = 0; i < database.customerList.size(); i++) {
            CustomerProf TempCustomerProf  = database.customerList.get(i);
            if(TempCustomerProf.getadminID().equals(adminID)) {
                displayCustomerProf(TempCustomerProf);
            }
        }
        */

        //if there is nothing in the customerlist, then there are no customer profiles to display
        if(database.getCustomerList().isEmpty()) {
            System.out.println("There are is no customer to display.");
            return;
        }
        if(!DoesCustomerProfExist(adminID)) { //uses helper function to ensure that adminID matches
            System.out.println("There is no customer profile listed under" + adminID + ".");
            return;
        }
        for(CustomerProf customerProf : database.getCustomerList()) {  //loops through the customer profiles in the CustomerList
            if(customerProf.getadminID().equals(adminID)) { //will only display the customer profiles associated with that adminID
                displayCustomerProf(customerProf);
                System.out.println("\n");
            }
        }
    }
    //will write all profiles currently in memory to the text file database that is provided to the application at application startup
    public void writeToDB(){
        try{
            database.writeAllCustomerProf(fileName);   // write all customer profiles to fileName
            System.out.println("Writing to DB was successful.");    // print success
        }
        // catch exceptions that may occur when calling write all
        catch(IOException e){
            System.out.println("Error writing to database.");
        }
    }


    /*
    All prompted inputs are used to create an instance of a customer profile
    This method will also invoke the updateVehicleInfo method so that the new customer profile
    also has their vehicle information
     */
    public void createNewCustomerProf() {
        //Creates new customer profile based on what the user has inputted
        Scanner inputadminID = new Scanner(System.in);
        System.out.println("Enter an adminID");
        String adminID = inputadminID.nextLine();
        Scanner CustProfScanner = new Scanner(System.in);
        System.out.println("Enter Customer's First Name");
        String firstName = CustProfScanner.nextLine();
        System.out.println("Enter Customer's Last Name");
        String lastName = CustProfScanner.nextLine();
        System.out.println("Enter Customer's Phone Number");
        String phone = CustProfScanner.nextLine();
        System.out.println("Enter Customer's Address");
        String address = CustProfScanner.nextLine();

        System.out.println("Enter Customer's Income");
        boolean check = false;
        float income = 0;
        while(!(check)) {
            try {
                income = Float.parseFloat(CustProfScanner.nextLine());
                check = true;
            }
            catch (Exception NumberFormatException) {
                System.out.println("Please enter a number for their Income");
            }
        }

        //Current status of the customer -- "Active" or "Inactive"
        System.out.println("Please enter new Status: ");
        String InputStatus = CustProfScanner.nextLine();
        while(!((InputStatus.equals("Active")) || (InputStatus.equals("Inactive")))) {
            System.out.println("Please enter \"Active\" or \"Inactive\"");
            InputStatus = CustProfScanner.nextLine();
        }
        String Newstatus = InputStatus;

        //Use of the vehicle -- "Business" or "Personal" or "Both"
        System.out.println("Please enter Use: ");
        String InputUse = CustProfScanner.nextLine();
        //Check if the inputted use is Business, Personal, or Both. if none, ask user again
        while (!((InputUse.equals("Business")) || (InputUse.equals("Personal")) || (InputUse.equals("Both")))) {
            System.out.println("Please enter \"Business\" or \"Personal\" or \"Both\"");
            InputUse = CustProfScanner.nextLine();
        }
        String Newuse = InputUse;

        //obtain the new vehicle information from the user
        VehicleInfo newVehicleInfo;
        newVehicleInfo = createNewVehicleInfo();

        //insert new profile
        CustomerProf newCustomerProf = new CustomerProf(adminID, firstName, lastName, address, phone, income, Newstatus, Newuse, newVehicleInfo);
        database.insertNewProfile(newCustomerProf);
    }

    VehicleInfo createNewVehicleInfo() {
        // will have the user input information for the vehicle information of the customer
        Scanner vehicleScanner = new Scanner(System.in);
        System.out.println("Enter Customer's Model");
        String vehicleModel = vehicleScanner.nextLine();
        System.out.println("Enter Customer's Vehicle's Year");
        String vehicleYear = vehicleScanner.nextLine();
        System.out.println("Enter Customer's Vehicle Type");
        String vehicleType = vehicleScanner.nextLine();
        System.out.println("Enter Customer's Vehicle Method");
        String vehicleMethod = vehicleScanner.nextLine();
        //now the new customer profile will also have its vehicle information
        VehicleInfo newVehInfo = new VehicleInfo(vehicleModel, vehicleYear, vehicleType, vehicleMethod);
        return newVehInfo;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "database/dbTestingText.txt"; //file path needed to reach the text file
        CustomerProfInterface apply = new CustomerProfInterface(fileName);
        apply.getUserChoice();
    }
}
