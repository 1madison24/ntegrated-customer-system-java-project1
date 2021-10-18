//import vehicleInfo;
//test
public class CustomerProf {
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    private class vehicleInfo;

    public CustomerProf() {
        super();
    }
    public CustomerProf(String adminID, String firstName, String lastName, String address, String phone,
                        float income, String status, String use) {
        super();
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.income = income;
        this.status = status;
        this.use = use;
        //this.vehicleInfo = vehicleInfo;

    }
    public String getadminID() {
        return adminID;
    }
    public String getfirstName() {
        return firstName;
    }
    public void UpdatefirstName(String firstName){
        this.firstName = firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public void UpdatelastName(String lastName){
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void UpdateAddress(String address){
        this.address = address;
    }
    public String getphone() {
        return phone;
    }
    public void Updatephone(String phone){
        this.phone = phone;
    }
    public float getincome() {
        return income;
    }
    public void Updateincome(float income){
        this.income = income;
    }
    public String getstatus() {
        return status;
    }
    public void Updatestatus(String status){
        this.status = status;
    }
    public String getuse() {
        return use;
    }
    public String getvehicleInfo() {
        return vehicleInfo;
    }
    public void UpdatevehicleInfo(class vehicleInfo){
        this.vehicleInfo = vehicleInfo;
    }
    public String toString() {
        return "CustomerProf [adminID =" + adminID + ", firstName =" + firstName + ", lastName =" + lastName +
                ", address =" + address + ", phone =" + phone + ", income =" + income +
                ", status =" + status + ", use =" + use + "]";
    }
}





//Ashely's code
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


























