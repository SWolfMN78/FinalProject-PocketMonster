package com.Shawn;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Wolfknightx on 5/3/2016.
 * User information pulled from SQL to be used.
 */
public class oUserInfo {
    public int ID;
    public String name;
    public String loginName;
    public String password;
    public int height;
    public int weight;
    public int monImageID; //this will contain the information used for the image eventually.
    public String MonName; //this will be used for the monster name.
    public int userDOB; //TODO figure out if this will be added - likely as an extra feature.
    //Gender may be applied at a later date.

    public oUserInfo(){
        //constructor place holder.
    }

    public oUserInfo(ResultSet resultSet){ // TODO this doesn't appear to be used - consider deleting
        try{
            ID = resultSet.getInt("UserID");
        }catch (SQLException sqle){
            System.out.println("Error setting up data " + sqle);
        }
    }

    public void createUserInSQL() {
        //create a prepared statement which will push a new record into SQL.
        try {
            String prepStateInsert = "Insert into USER (Login, Password, Name, Height, Weight, MonsterID, MonsterName) values (?, ?, ?, ?,?, ?, ?)";
            PreparedStatement psInsert = Main.conn.prepareStatement(prepStateInsert);
            psInsert.setString(1, loginName);
            psInsert.setString(2, password);
            psInsert.setString(3, name);
            psInsert.setInt(4, height);//convert the string information into an int.
            psInsert.setInt(5, weight);//same as above.
            psInsert.setInt(6, monImageID); //this will hold the monster image ID (1-3).
            psInsert.setString(7, MonName);
            psInsert.executeUpdate();
            psInsert.close();
        }catch (SQLException sqle){
            System.out.println("Error! Couldn't insert information." + sqle);
        }
            //TODO consider if a duplicate username and/or password is used....who logs in?
    }

    public void logInSQLUser(String loginName, String password){
        //build a resultSet statement which will pull the user information and store it for the program to make use of.
        try {
            ResultSet rs = null; //variable for the resultset that will be used soon (below)
            String getUserData = "select * from user where Login = ? AND Password = ?"; //Prepared statement to be used *secure the information from tampering*
            PreparedStatement psSelect = Main.conn.prepareStatement(getUserData);
            psSelect.setString(1, loginName);
            psSelect.setString(2, password);
            rs = psSelect.executeQuery(); //set the result set to match up with the information from the prepared statment.
            rs.last();
            if (rs.getRow() > 0){
                // If it did match allow the user to move forward.
                ID = rs.getInt("idUser");
                loginName = rs.getString("login");
                password = rs.getString("Password");
                name = rs.getString("Name");
                height = rs.getInt("Height");
                weight = rs.getInt("Weight");
                monImageID = rs.getInt("MonsterID");
                MonName = rs.getString("MonsterName");
            }
        }catch (SQLException sqle2){
            System.out.println(sqle2);
        }
    }
}
