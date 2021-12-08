package projectGUI;

import java.nio.file.Path;
import java.nio.file.Paths;

public class getPath {
    public static Path thePath = Paths.get("src/dbTestingText.txt");
    public static Path getIt(){
        return thePath;
    }
    public static void main(String[] args){
    }
}
