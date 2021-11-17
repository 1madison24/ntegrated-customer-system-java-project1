package projectGUI;
import java.io.Serializable;

public class CustCond implements Serializable{
    String Usecar;
    String statuscar;
    String typecar;
    String methodcar;

    public CustCond(String patUsecar, String patstatuscar,
                    String pattypecar, String patmethodcar) {

        Usecar = patUsecar;
        statuscar = patstatuscar;
        typecar = pattypecar;
        methodcar = patmethodcar;
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
