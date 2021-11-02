package CustomerProf;
import VehicleInfo.VehicleInfo;
//test

/* Keeps track of different characteristics of a customer’s profile, i.e., name, address,
  phone number, number of years since the individual is a customer, customer status (active or inactive),
  whether the vehicle is for personal or business use or both */
public class CustomerProf {
    //the following information about the customer are kept private
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    VehicleInfo VehicleInfo; //an attribute


    public CustomerProf(String person_adminID, String person_firstName, String person_lastName, String person_address,
                        String person_phone, float person_income, String person_status, String person_use, VehicleInfo person_VehicleInfo) {
        //initialization
        adminID = person_adminID;
        firstName = person_firstName;
        lastName = person_lastName;
        address = person_address;
        phone = person_phone;
        income = person_income;
        status = person_status;
        use = person_use;
        VehicleInfo = person_VehicleInfo;

    }
    public String getadminID() {
        return adminID;
    }
    public String getfirstName() {
        return firstName;
    }
    //replace the old information stored in firstName with the new first name
    public void UpdatefirstName(String NewfirstName){
        firstName = NewfirstName;
    }
    public String getlastName() {
        return lastName;
    }
    //replace the old information stored in lastName with the new last name
    public void UpdatelastName(String NewlastName){
        lastName = NewlastName;
    }
    public String getAddress() {
        return address;
    }
    //replace the old information stored in address with the new address of the customer
    public void UpdateAddress(String Newaddress){
        address = Newaddress;
    }
    public String getphone() {
        return phone;
    }
    //replace the old information stored in phone with the new phonenumber
    public void Updatephone(String Newphone){
        phone = Newphone;
    }
    public float getincome() {
        return income;
    }
    //replace the old information stored in income with the new income information of the customer
    public void Updateincome(float Newincome){
        income = Newincome;
    }
    public String getstatus() {
        return status;
    }
    //replace the old info stored in status with the customer's new status
    public void Updatestatus(String Newstatus){
        status = Newstatus;
    }
    public String getuse() {
        return use;
    }
    //replace the old info stored in use with the customer's new use
    public void UpdateUse(String newUse) {
        use = newUse;
    }
    public VehicleInfo getvehicleInfo() {
        return VehicleInfo;
    }
    //update the customer's vehicle information
    public void UpdatevehicleInfo(VehicleInfo NewVehicleInfo){
     VehicleInfo = NewVehicleInfo;
    }
    public String toString() {
        return "CustomerProf [adminID =" + adminID + ", firstName =" + firstName + ", lastName =" + lastName +
                ", address =" + address + ", phone =" + phone + ", income =" + income +
                ", status =" + status + ", use =" + use + "]";
    }
}






/* // keeps track of different characteristics of a customer's profile, i.e., name, address, phone number, number of years
// since the individuals is a customer, customer status (active or inactive), whether the vehicle is for personal use or both

public class CustomerProf {
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    private VehicleInfo vehicleInfo; //??? is this right?

    public CustomerProf(String custAdminID, String custFirstName, String custLastName, String custAddress, String custPhone,
                        float custIncome, String custStatus, String custUse) {
        adminID = custAdminID;
        firstName = custFirstName;
        lastName = custLastName;
        address = custAddress;
        phone = custPhone;
        income = custIncome;
        status = custStatus;
        use = custUse;
    }

    public String getadminID() {
        return adminID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public float getIncome() {
        return income;
    }
    public String getStatus() {
        return status;
    }
    public String getUse() {
        return use;
    }
    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }
    public void updateFirstName(String newFirstName) {
        firstName = newFirstName;
    }
    public void updateLastName(String newLastName) {
        lastName = newLastName;
    }
    public void updateAddress(String newAddress) {
        address = newAddress;
    }
    public void updatePhone(String newPhone) {
        phone = newPhone;
    }
    public void updateIncome (float newIncome) {
        income = newIncome;
    }
    public void updateStatus(String newStatus) {
        status = newStatus;
    }
    public void updateVehicleInfo(VehicleInfo newVehicleInfo) {
        vehicleInfo = newVehicleInfo;
    }
}


 */











































