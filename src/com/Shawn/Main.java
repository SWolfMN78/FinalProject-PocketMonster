package com.Shawn;

import java.sql.*;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_Name = "dbpocketmon";
    static final String USER = "root";
    static final String PASSWORD = "";

    static Statement statement = null;
    static Connection conn = null;
    static ResultSet rs = null;
    static int userID;

    public static void main(String[] args) {
	// This is my final project - desired outcome is to create an application which users can select a digitial play
        //mate and fitness monster.  Users will be able to create and load accounts, track progress and play a simple game
        //with their pocket monster by the end.
        //extras - play games and have the monster react to the win/loss ratio, show prgress of monster over time, select new monsters.
            //raise new monsters, fire specilized errors pending different actions.
        OpeningPageGUI opGUI = new OpeningPageGUI(); //Load up the opening screen.
        // TODO the user input page is pending changes - may move this to a dialog box instead.
        setup(); //set up connection to database.
    }

    public static void setup(){
        //call the SQL database to get the information lined up.
        try{
            try{
                String Driver = JDBC_DRIVER; //try and to open the driver to run sql.
                Class.forName(Driver);
            }catch (ClassNotFoundException cnfe){
                System.out.println("No database drivers found. Quitting");
                System.exit(-1);
            }
            //now that MySQL is open and running, lets start the connection to the DB with the user name & PW
            conn = DriverManager.getConnection(DB_CONNECTION_URL + DB_Name, USER, PASSWORD);
            statement = conn.createStatement();
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        }catch (SQLException sqle){
            System.out.println("The cubes table already exist, check SQL for any possible issues.");
            System.out.println(sqle);
        }
    }
}
