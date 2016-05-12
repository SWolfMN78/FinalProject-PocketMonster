package com.Shawn;

import sun.font.FontScaler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Wolfknightx on 4/25/2016.
 * Loading screen and section to select a new user or load an existing one.
 */
public class OpeningPageGUI extends JFrame {
    private JPanel rootPanel;
    private JButton btnNewUser;
    private JButton btnLoadUser;
    private JButton btnQuit;
    private JPanel PictureDisplay;


    public OpeningPageGUI() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

//        BufferedImage tPictureLoaded = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
//        final BufferedImage image = ImageIO.read(new File("Monster Test Picture1.png"));
//
//        JPanel pane = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(image, 0, 0, null);
//            }
//        };
//
//
//        frame.add(pane);

        //set up the buttons for the application
        buttonconfig();
    }

    public void buttonconfig(){
        //set buttons to be used..
        btnNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateNewUserGUI cnuGUI = new CreateNewUserGUI(); //new user creation.
                cnuGUI.setVisible(true); //show the next window that the user will be using.
                setVisible(false); //hide the main window from view
            }
        });
        btnLoadUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //If a return user then load up the following information
                LoginPageGUI lpGUI = new LoginPageGUI(); //user login page.
                lpGUI.setVisible(true);//hide the main page from view.
                setVisible(false);
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting program.");  //only from here will Quit close out to the entire program.
                Main.shutdown(); //close out of the program completely.
                System.exit(0); // and close out of the complete program
            }
        });
    }
}
