package projectGUI;

import java.nio.file.Path;
import java.nio.file.Paths;

public class getPath {
    //Creates a path to the Database.txt file for the GUIs to write to 
    public static Path thePath = Paths.get("src/dbTestingText.txt");
    public static Path getIt(){
        return thePath;
    }
    public static void main(String[] args){
    }
}
