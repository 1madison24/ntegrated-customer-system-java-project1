package projectGUI;
import java.io.Serializable;

//this code is similar to that from vehicleInfo
//this class returns some of the vehicle information pertaining to a certain customer

public class CustCond implements Serializable{
    String Usecar;
    String statuscar;
    String typecar;
    String methodcar;

    public CustCond(String cusUsecar, String cusstatuscar,
                    String custypecar, String cusmethodcar) {

        Usecar = cusUsecar;
        statuscar = cusstatuscar;
        typecar = custypecar;
        methodcar = cusmethodcar;
    }

    public String getUsecar(){
        return Usecar;
    }

    public String getstatuscar(){
        return statuscar;
    }

    public String gettypecar(){
        return typecar;
    }

    public String getmethodcar(){
        return methodcar;
    }
    public void updateUsecar(String newUsecar){
        Usecar = newUsecar;
    }

    public void updatestatuscar(String newstatuscar){
        statuscar = newstatuscar;
    }

    public void updatetypecar(String newtypecar){
        typecar = newtypecar;
    }
    public void updatemethodcar(String newmethodcar){
        methodcar = newmethodcar;
    }
}
