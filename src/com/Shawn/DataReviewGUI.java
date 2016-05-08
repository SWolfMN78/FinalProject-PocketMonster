package com.Shawn;

import com.mysql.jdbc.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedWriter;

/**
 * Created by Wolfknightx on 4/25/2016.
 * This datatable will be used for users to review information.
 * Users review - their starting and most current entered stats.
 */
public class DataReviewGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnPrint;
    private JButton btnClose;
    private JLabel lblCurrentUserInfo;
    private JLabel lblActivityLog;
    private JTextPane txtpActivityLogInfo;
    private JTextPane txtpUserInfo;


    private ResultSet rs = null;
    String valueInformation = ""; //store the user's information.
    String dataInformation = ""; //store the user's data

    DataReviewGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        //set up the buttons for the application
        buttonconfig();
        popResultSet(); //call the result set to get the information from sql.
        popUserInfo();

        //close out the jFrame once done
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void popResultSet(){
        //pull the information to load into our labels.
        try {
            if (rs!=null){
                rs.close();
            }
            //union selection statement to pull information from multiple tables to display back to the user.
            String getUserData = "select * from (\n" +
                    "select idUser_Weight idUser, 'Weight' tableName, wtdate date, weight actValue from Weight\n" +
                    "union all\n" +
                    "select idUser_Water idUser, 'Water' tableName, date, waterconsumed actValue from water\n" +
                    "union all\n" +
                    "select idUser_Excer idUser, 'Excercise' tablename, date, cardioTime actValue from excercise\n" +
                    "union all\n" +
                    "select idUser_Measure idUser, 'Measurements' tablename, date, concat('hip:','', hipMeasure, '',' chest:', '', chestMeasure)  actValue from measurements\n" +
                    ") as a\n" +
                    "where idUser = ?\n" +
                    "order by date;";

            //build prepared statement to be adjustable for other user ID's.
                PreparedStatement psSelectInfo = Main.conn.prepareStatement(getUserData);
            psSelectInfo.setInt(1, Main.userInfo.ID);
            rs = psSelectInfo.executeQuery();

            //while there are rows to review lets walk through the resultset and display the information.
            while(rs.next()){
                valueInformation += "Date: " + rs.getString("Date");
                valueInformation += "Table: " + rs.getString("TableName");
                valueInformation += "Value: " + rs.getString("actValue") + ". ";
                valueInformation += "\n";
            }
            txtpActivityLogInfo.setText(valueInformation);
            rs.close(); //close the resultset.

        }catch (Exception e){
            System.out.println("Error loading user information");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void popUserInfo(){
        //utilize the information located from the user that is logged in already through UserInfo to populate the following data.
        dataInformation += "User Name: " + Main.userInfo.name.toUpperCase().trim() + "\n";
        dataInformation += "Monster Name: " + Main.userInfo.monName.toUpperCase().trim() +"\n";
        txtpUserInfo.setText(dataInformation);
    }

    public void buttonconfig(){
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //write the information from the above fields to a txt document for the user to review.
                try{
                    FileWriter writer = new FileWriter("UserInformation Review.txt");
                    BufferedWriter bufwriter = new BufferedWriter(writer);

                    //insert the information to be written
                    bufwriter.write(dataInformation);
                    bufwriter.write(valueInformation);
                    bufwriter.close();
                    JOptionPane.showMessageDialog(rootPanel, "Your information has been printed!");
                }catch (Exception ex){
                    System.out.println("Error with writting information" + ex);
                }

            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logging Admin out");
                OpeningPageGUI opGUI = new OpeningPageGUI(); //log the admin out and go back to the screen
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
    }
}
