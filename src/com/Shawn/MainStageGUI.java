package com.Shawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 * Created by Wolfknightx on 4/25/2016.
 * From here the user will be able to log changes to their application for fitness and play with their Monsters.
 */
public class MainStageGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnPrint;
    private JButton btnNewExcersise;
    private JButton btnNewWaterLog;
    private JButton btnQuit;
    private JButton btnReviewData;
    private JButton btnNewHeight;
    private JButton btnNewMeasurements;
    private JButton btnNewWeight;
    private JButton btnPlayTTT;
    private JPanel pnlPictureBox;
    java.util.Date x = new Date();
    java.sql.Date time = new java.sql.Date(x.getTime());

    MainStageGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        //access the set buttons.
        buttonConfig();
    }

    public void buttonConfig(){
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnReviewData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();

                // TODO insure that when this window is opened that only the ADMIN has rights to alter the tables.
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel,"Going back to main page.", "Cancel",JOptionPane.CANCEL_OPTION);
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
            }
        });

        btnNewExcersise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create variables to store the information for the user's measurements.
                int cardioTime;
                java.sql.Date excersiseTime = time;

                //pull the information from the user
                String dlExcersiseInfo = JOptionPane.showInputDialog("Please enter time spent doing cardio in minutes.");

                //push the information into sql
                try{
                    if (dlExcersiseInfo.equals("") || dlExcersiseInfo.equals(0)){
                        JOptionPane.showMessageDialog(rootPanel, "You must enter a value greater than 0", "Error", JOptionPane.ERROR);
                    }
                    cardioTime = Integer.parseInt(dlExcersiseInfo); //parse the information to insure a digit is entered.
                    String preparedStatement = "Insert into excercise (idUser_Excer, Date, cardioTime) values (?, ?, ?)";
                    PreparedStatement pswInsert = Main.conn.prepareStatement(preparedStatement);
                    pswInsert.setInt(1, Main.userInfo.ID);
                    pswInsert.setDate(2, excersiseTime);
                    pswInsert.setInt(3, cardioTime);
                    pswInsert.execute();
                    pswInsert.close();
                }catch (SQLException sqle){
                    System.out.println("Information not saved, Couldn't push the information to the database." + sqle);
                }
            }
        });
        btnNewMeasurements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create variables to store the information for the user's measurements.
                int hipMeasurement;
                int chestMeasure;
                java.sql.Date measureTime = time;

                //pull the information from the user
                String dlMeasureInfo1 = JOptionPane.showInputDialog("Please enter your hip measurement (in inches).");
                String dlMeasureInfo2 = JOptionPane.showInputDialog("Please enter your chest measurement (in inches).");

                //push the information into sql
                try{
                    if (dlMeasureInfo1.equals("") || dlMeasureInfo1.equals(0) && dlMeasureInfo2.equals("")
                            && dlMeasureInfo2.equals(0)){
                        JOptionPane.showMessageDialog(rootPanel, "You must enter a value greater than 0", "Error", JOptionPane.ERROR);
                    }
                    hipMeasurement = Integer.parseInt(dlMeasureInfo1); //parse the information to insure a digit is entered.
                    chestMeasure = Integer.parseInt(dlMeasureInfo2);
                    String preparedStatement = "Insert into measurements (idUser_Measure, Date, hipMeasure, chestMeasure) values (?, ?, ?, ?)";
                    PreparedStatement pswInsert = Main.conn.prepareStatement(preparedStatement);
                    pswInsert.setInt(1, Main.userInfo.ID);
                    pswInsert.setDate(2, measureTime);
                    pswInsert.setInt(3, hipMeasurement);
                    pswInsert.setInt(4, chestMeasure);
                    pswInsert.execute();
                    pswInsert.close();
                }catch (SQLException sqle){
                    System.out.println("Information not saved, Couldn't push the information to the database." + sqle);
                }
            }
        });
        btnNewWaterLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int waterConsumed;
                java.sql.Date waterTime = time;

                String dlWaterInfo = JOptionPane.showInputDialog("Please enter the amount of water entered.");

                try{
                    if (dlWaterInfo.equals("") || dlWaterInfo.equals(0)){
                        JOptionPane.showMessageDialog(rootPanel, "You must enter a value greater than 0", "Error", JOptionPane.ERROR);
                    }
                    waterConsumed = Integer.parseInt(dlWaterInfo);
                    String preparedStatement = "Insert into Water (idUser_Water, Date, Waterconsumed) values (?, ?, ?)";
                    PreparedStatement pswInsert = Main.conn.prepareStatement(preparedStatement);
                    pswInsert.setInt(1, Main.userInfo.ID);
                    pswInsert.setDate(2, waterTime);
                    pswInsert.setInt(3, waterConsumed);
                    pswInsert.execute();
                    pswInsert.close();
                }catch (SQLException sqle){
                    System.out.println("Information not saved, Couldn't push the information to the database." + sqle);
                }
            }
        });
        btnNewWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newWeight;
                java.sql.Date weightTime = time;

                String dlWeightInfo = JOptionPane.showInputDialog("Please enter your new weight value in pounds.");

                try{
                    if (dlWeightInfo.equals("") || dlWeightInfo.equals(0)){
                        JOptionPane.showMessageDialog(rootPanel, "You must enter a value greater than 0", "Error", JOptionPane.ERROR);
                    }
                    newWeight = Integer.parseInt(dlWeightInfo);
                    String preparedStatement = "Insert into weight (iduser_Weight, wtDate, Weight) values (?, ?, ?)";
                    PreparedStatement pswInsert = Main.conn.prepareStatement(preparedStatement);
                    pswInsert.setInt(1, Main.userInfo.ID);
                    pswInsert.setDate(2, weightTime);
                    pswInsert.setInt(3, newWeight);
                    pswInsert.execute();
                    pswInsert.close();
                }catch (SQLException sqle){
                    System.out.println("Information not saved, Couldn't push the information to the database." + sqle);
                }
            }
        });

        btnPlayTTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
    }

    public void nonFunction(){
        JOptionPane.showMessageDialog(rootPanel, "Feature available upon purchase!", "Pending Operation",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
