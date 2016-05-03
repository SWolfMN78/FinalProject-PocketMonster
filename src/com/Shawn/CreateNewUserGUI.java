package com.Shawn;

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
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JComboBox cmbxMonth;
    private JComboBox cmbxDay;
    private JComboBox cmbxYear;

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
    }

    public void buttonConfig() {
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isEmptyField()){
                    MonsterSelectGUI msGUI = new MonsterSelectGUI();
                    msGUI.setVisible(true);
                    setVisible(false);
                    oUserInfo userInfo = new oUserInfo();
                    //for reading sake figured this way would be easier.
                    userInfo.name = txtUserName.getText();
                    userInfo.loginName = txtLogin.getText();
                    userInfo.password = txtPassword.getText();
                    userInfo.height = txtHeight.getText();
                    userInfo.weight = txtWeight.getText();
                    //userInfo.userDOB; //TODO come back and add information on if this will be added.
                    userInfo.createUserInSQL();
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
                txtHeight.setText("");
                txtWeight.setText("");
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
        if (txtLogin.getText().equals("")){
            JOptionPane.showMessageDialog(rootPanel, "Information must be entered into the Login field");
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
}
