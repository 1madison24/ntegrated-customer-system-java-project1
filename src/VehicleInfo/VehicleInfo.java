package VehicleInfo;
import java.util.*;
//keeps track of the details of the vehicle owned by the customer
public class VehicleInfo {
    private String model;   //name of the vehicle model
    private String year;    //year in which the vehicle was manufactured
    private String type;    //type of vehicle, must select from: sedan, hatchback, luxury, sport, other
    private String method;  //how the vehicle was acquired -- must select from: new certified pre-owned, used, other


    //will utilize these HashSets for boolean values during conditional statements
    private HashSet<String> validType = new HashSet<>(Arrays.asList("sedan", "hatchback", "luxury", "sport", "other"));
    private HashSet<String> validMethod = new HashSet<>(Arrays.asList("new", "certified pre-owned", "used", "other"));


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
        try{
            if((Integer.parseInt(NewYear) > 999) && (Integer.parseInt(NewYear) < 10000)) {
                year = NewYear;
            }
            else {
                throw new IllegalArgumentException(("Year is invalid: Correct format should have 4 digits: e.x 2022")); //that way the user knows how to format their input
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(("Year is invalid: Correct format should have 4 digits: e.x 2022")); //that way user knows how to format their input
        }
    }

    public void updateType(String NewType) { //reassigns the type variable to the new one
        if (validType.contains(NewType.toLowerCase(Locale.ROOT))) {
            type = NewType.toLowerCase(Locale.ROOT);
        }
        else {
            throw new IllegalArgumentException("Type needs to be one of the following: sedan, hatchback, luxury, sport, other"); //that way user can know what to type in
        }
    }

    public void updateMethod(String NewMethod) { //reassigns the method variable to the new one
        if(validMethod.contains(NewMethod.toLowerCase(Locale.ROOT))) {
            method = NewMethod;
        }
        else {
            throw new IllegalArgumentException("Model needs to be one of these: new, certified, pre-owned, used, other");
        }


    }
}
//does not return anything, but updates the vehicle information
