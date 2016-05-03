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
    public String height; //will need converting to an int.
    public String weight; //will need converting to an int.
    public int userDOB; //TODO figure out if this will be added - likely as an extra feature.
    //Gender may be applied at a later date.

    public oUserInfo(){

    }

    public oUserInfo(ResultSet resultSet){
        try{
            ID = resultSet.getInt("UserID");
        }catch (SQLException sqle){
            System.out.println("Error setting up data " + sqle);
        }

    }

    public void createUserInSQL() {
        //create a prepared statement which will push a new record into SQL.
        try {
            String prepStateInsert = "Insert into USER (Login, Password, Name, Height, Weight) values (?, ?, ?, ?, ?)";
            PreparedStatement psInsert = Main.conn.prepareStatement(prepStateInsert);
            psInsert.setString(1, loginName);
            psInsert.setString(2, password);
            psInsert.setString(3, name);
            psInsert.setInt(4, Integer.parseInt(height));//convert the string information into an int.
            psInsert.setInt(5, Integer.parseInt(weight));//same as above.
            psInsert.executeUpdate();
            psInsert.close();
        }catch (SQLException sqle){
            System.out.println("Error! Couldn't insert information." + sqle);
        }
            //TODO consider if a duplicate username and/or password is used....who logs in?
    }

    public void logInSQLUser(ResultSet resultSet){
        //build a resultSet statement which will pull the user information and store it for the program to make use of.
        try {
            ID = resultSet.getInt("UserID");
            loginName = resultSet.getString("login");

        }catch (SQLException sqle2){
            System.out.println(sqle2);
        }
    }
}
