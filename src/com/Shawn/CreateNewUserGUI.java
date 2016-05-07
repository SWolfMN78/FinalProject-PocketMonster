package com.Shawn;

import sun.awt.WindowIDProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 * This form will be used for users to create a new account and sign on.
 */
public class CreateNewUserGUI extends JFrame {
    private JPanel rootPanel;
    private JButton btnEnter;
    private JButton btnCancel;
    private JButton btnClear;
    public JTextField txtUserName;
    private JTextField txtLogin;
    private JTextField txtPassword;
    private JComboBox cmbxMonth;
    private JComboBox cmbxDay;
    private JComboBox cmbxYear;
    private JComboBox cmbxHeight;
    private JComboBox cmbxWeight;
    private JTextField txtMonsterName;
    private JRadioButton rdoMonster1;
    private JRadioButton rdoMonster2;
    private JRadioButton rdoMonster3;
    private JPanel pnlMonsterDisplay;
    MainStageGUI msGUI = new MainStageGUI();
    oUserInfo userInfo = new oUserInfo();

    CreateNewUserGUI() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        buttonConfig();
        configureDDMonth();
        configureDDDay();
        configureDDYear();
        configureDDWeight();
        txtMonsterName.setText(""); //setting this to a blank string to be on the safe side.
    }

    public void buttonConfig() {
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isEmptyField()){
                    //for reading sake figured this way would be easier.
                    userInfo.name = txtUserName.getText();
                    userInfo.loginName = txtLogin.getText();
                    userInfo.password = txtPassword.getText();
                    userInfo.height = Integer.valueOf((String)cmbxHeight.getSelectedItem());
                    userInfo.weight = Integer.valueOf((String)cmbxWeight.getSelectedItem());
                    //userInfo.userDOB; //TODO come back and add information on if this will be added.
                    userInfo.createUserInSQL();

                    if(isMonsterNameBlank() == true){
                        msGUI.setVisible(true);
                        setVisible(false);
                    } else if (isMonsterNameBlank() == false){
                        JOptionPane.showMessageDialog(rootPanel, "You must select a monster to move forward.","Select Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clear the current information and allow the user to start over.
                txtUserName.setText("");
                txtLogin.setText("");
                txtPassword.setText("");
                txtMonsterName.setText("");
                rdoMonster1.setSelected(false);
                rdoMonster2.setSelected(false);
                rdoMonster3.setSelected(false);
                cmbxMonth.setSelectedIndex(0);
                cmbxDay.setSelectedIndex(0);
                cmbxYear.setSelectedIndex(0);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Going back to main page.", "Cancel", JOptionPane.CANCEL_OPTION);
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
    }

    public boolean isEmptyField(){
        //if the text fields are blank then fire a msg.
        if (txtLogin.getText().trim().equals("") || txtUserName.getText().trim().equals("")
                || txtPassword.getText().trim().equals("") || txtMonsterName.getText().trim().equals("")){
            JOptionPane.showMessageDialog(rootPanel, "Fill in all text fields to create your account!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        } return false;
    }
    public void configureDDMonth () {
        //button drop down for the month
        for (int x = 1; x < 13; x++) {
            cmbxMonth.addItem(x);
        }
    }
    public void configureDDDay() {
        //button dropdown for the month
        for (int x = 1; x < 32; x++) { //Does not include leap years.
            cmbxDay.addItem(x);
        }
    }
    public void configureDDYear() {
        //dropdown information for the year.
        for (int x = 101; x > -1; x--) {  //not that it wouldn't happen but I wanted this in here.
            cmbxYear.addItem (2016 - x);
        }
    }
    public void configureDDHeight(){
        //set the drop down to display a range of fights to select from.

    }
    public void configureDDWeight(){
        for (int x = 100; x < 300; x++){
            cmbxWeight.addItem(x);
        }
    }
    public boolean isMonsterNameBlank(){
        //user must input a name for their monster.
        if (txtMonsterName.getText().trim().equals("")){
            return false; //name is blank.
        } return true; //name is filled in.
    }
}
