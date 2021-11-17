package projectGUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class DBController {

    public static void main(String[] args){
        CreateProfile v = new CreateProfile();
        v.openGUI();
//        v.buildProf();

    }
    public static void addProfile(List<String> userInfo, Path path){
        List<String> temp = userInfo;
        for (int i = 0; i < 12; i++){
            try{
                temp.set(i, userInfo.get(i) + "\n");
                Files.write(path, temp.get(i).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> getAllProfiles(String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        List<String> rightProfiles = new ArrayList<>();
        try{
            allProfiles = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i))){
                for(int j = 0; j < 12; j++){
                    rightProfiles.add(allProfiles.get(i+j));
                }
            }
        }
        return rightProfiles;
    }

    public static List<String> getProfileByLastName(String Lastname, String adminID, Path path){
       List<String> allProfiles = new ArrayList<>();
       List<String> desiredProfile = new ArrayList<>();
       try {
           allProfiles = Files.readAllLines(path);
       } catch (IOException e) {
           e.printStackTrace();
       }
       int start = 0;
       for (int i= 2; i<allProfiles.size(); i++){
           if(adminID.equals(allProfiles.get(i-2)) && Lastname.equals(allProfiles.get(i))){
               start = i - 2;
               for(int j = start; j< (start+12); j++){
                   desiredProfile.add(allProfiles.get(j));
               }
           }
        }
       return desiredProfile;
    }
    public static void deleteProfileByLastname(String Lastname, String adminID, Path path){
       List<String> allProfiles = new ArrayList<>();
       try {
           allProfiles = Files.readAllLines(path);
       } catch (IOException e){
           e.printStackTrace();
       }
       int start = 0;
       for (int i = 2; i < allProfiles.size(); i++){
           if(adminID.equals(allProfiles.get(i-2)) && Lastname.equals(allProfiles.get(i))){
               start = i -2;
               for(int j = start; j<(start+12); j++){
                   allProfiles.remove(start);
               }
               break;
           }
       }
       try {
           Files.delete(path);
       } catch(IOException e){
           e.printStackTrace();
       }
       try {
           Files.createFile(path);
       } catch (IOException e){
           e.printStackTrace();
       }
        for (int i = 0; i < allProfiles.size(); i++){
            allProfiles.set(i, allProfiles.get(i) + "\n");
            try {
                Files.write(path, allProfiles.get(i).getBytes(), StandardOpenOption.APPEND);  //Append mode
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void updateProfileByLastName(String Lastname, String updatedInfo, int indexOfUpdate, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        int delDetail = 0;
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        int start = 0;
        for (int i = 2; i<allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i-2))&& Lastname.equals(allProfiles.get(i))){
                start = i-2;
                delDetail = start+indexOfUpdate;
            }
        }
        allProfiles.remove(delDetail);
        allProfiles.add(delDetail, updatedInfo);

        try {
            Files.delete(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < allProfiles.size(); i++){
            allProfiles.set(i, allProfiles.get(i) + "\n");
            try {
                Files.write(path, allProfiles.get(i).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static boolean searchProfile(String Lastname, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        boolean select = false;
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 2; i<allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i-2)) && Lastname.equals(allProfiles.get(i))){
                select = true;
            }
        }
        return select;
    }
}
