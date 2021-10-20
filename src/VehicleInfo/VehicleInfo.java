package VehicleInfo;
//keeps track of the details of the vehicle owned by the customer
public class VehicleInfo {
    private String model;   //name of the vehicle model
    private String year;    //year in which the vehicle was manufactured
    private String type;    //type of vehicle, must select from: sedan, hatchback, luxury, sport, other
    private String method;  //how the vehicle was acquired -- must select from: new certified pre-owned, used, other

    public VehicleInfo(String vehicle_model, String vehicle_year, String vehicle_type, String vehicle_method) {
        model = vehicle_model;
        year = vehicle_year;
        type = vehicle_type;
        method = vehicle_method;
    }

    public String getModel() { //returns the model
        return model;
    }

    public String getYear() { //returns the year
        return year;
    }

    public String getType() { //returns the type
        return type;
    }

    public String getMethod() { //returns the method
        return method;
    }

    public void updateModel(String NewModel) { //reassigns the model variable to the new one
        model = NewModel;
    }

    public void updateYear(String NewYear) { //reassigns the year variable to the new one
        year = NewYear;
    }

    public void updateType(String NewType) { //reassigns the type variable to the new one
        type = NewType;
    }

    public void updateMethod(String NewMethod) { //reassigns the method variable to the new one
        method = NewMethod;
    }
}
//does not return anything, but updates the vehicle information