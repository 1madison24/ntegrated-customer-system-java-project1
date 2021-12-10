package projectGUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.List;

public class DBController {

    public static void main(String[] args){
        IntCustSysMenu i = new IntCustSysMenu();
        i.openGUI(); //opens up the integrated customer system menu window

    }
    public static void addProfile(List<String> userInfo, Path path){
        for (int i = 0; i < 12; i++){
            try{
                userInfo.set(i, userInfo.get(i) + "\n");
                Files.write(path, userInfo.get(i).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> getAllProfiles(String adminID, Path path){
        //out of all the profiles, choose the profiles that match the adminID
        List<String> allProfiles = new ArrayList<>();
        List<String> matchProfiles = new ArrayList<>();
        try{
            allProfiles = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //two for loops used for O(n^2) time so we can iterate through the array while keeping track of the first index, and then the next, and so on to find the matching profiles
        for (int i = 0; i < allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i))){
                for(int j = 0; j < 12; j++){
                    matchProfiles.add(allProfiles.get(i+j));
                }
            }
        }
        return matchProfiles;
    }

 /*   public static List<String> getCorrespondingLastNames(String adminID, Path path){
        //out of all the profiles, choose the profiles that match the adminID
        List<String> allProfiles = new ArrayList<>();
        List<String> matchProfiles = new ArrayList<>();
        List<String> lastNamesList = new ArrayList<>();
        try{
            allProfiles = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //two for loops used for O(n^2) time so we can iterate through the array while keeping track of the first index, and then the next, and so on to find the matching profiles
        for (int i = 0; i < allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i))){
                for(int j = 0; j < 12; j++){
                    matchProfiles.add(allProfiles.get(i+j));
                }
            }
        }
        return matchProfiles;
    } */

    //will obtain the correct profile based on the last name and adminID
    public static List<String> getProfileByLastName(String lastname, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        List<String> matchingProfile = new ArrayList<>();
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int begin;
        for (int i= 2; i<allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i-2)) && lastname.equals(allProfiles.get(i))){
                begin = i - 2;
                for(int j = begin; j< (begin+12); j++){
                    matchingProfile.add(allProfiles.get(j));
                }
            }
        }
        return matchingProfile;
    }
    
    //will delete the profile when provided the adminID and the lastname that corresponds to that adminID
    public static void deleteProfileByLastname(String lastname, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        int begin;
        for (int i = 2; i < allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i-2)) && lastname.equals(allProfiles.get(i))){
                begin = i -2;
                if ((begin + 12) > begin) {
                    allProfiles.subList(begin, (begin + 12)).clear();
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
    
    //update the profile when provided the adminID and last name
    public static void updateProfileByLastName(String lastname, String updatedInfo, int indexOfUpdate, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        int delDetail = 0;
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        int begin;
        for (int i = 2; i < allProfiles.size(); i++){
            if(adminID.equals(allProfiles.get(i-2))&& lastname.equals(allProfiles.get(i))){
                begin = i-2;
                delDetail = begin+indexOfUpdate;
            }
        }
        System.out.println(allProfiles);
        System.out.println(delDetail);
        allProfiles.remove(delDetail); //remove the detail you wanted to delete
        allProfiles.add(delDetail, updatedInfo); //in place of where you had deleted the detail, add the new info you wanted to add

//        try {
//            Files.delete(path);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        for (int i = 0; i < allProfiles.size(); i++){
            allProfiles.set(i, allProfiles.get(i) + "\n");
            try {
                Files.write(path, allProfiles.get(i).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static boolean searchProfile(String lastname, String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        boolean select = false; //select is set to false until proven true
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 2; i < allProfiles.size(); i++){
            if (adminID.equals(allProfiles.get(i - 2)) && lastname.equals(allProfiles.get(i))) {
                select = true; //select is now true since the profile is in the database
                break;
            }
        }
        return select; //then the boolean value
    }
    public static boolean searchAllProfiles(String adminID, Path path){
        List<String> allProfiles = new ArrayList<>();
        boolean select = false; //select is set to false until proven true
        try {
            allProfiles = Files.readAllLines(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 2; i < allProfiles.size(); i++){
            if (adminID.equals(allProfiles.get(i - 2))) {
                select = true; //select is now true since the profile is in the database
                break;
            }
        }
        return select; //then the boolean value
    }
}
