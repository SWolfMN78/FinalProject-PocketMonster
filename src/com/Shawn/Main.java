package com.Shawn;

public class Main {

    public static void main(String[] args) {
	// This is my final project - desired outcome is to create an application which users can select a digitial play
        //mate and fitness monster.  Users will be able to create and load accounts, track progress and play a simple game
        //with their pocket monster by the end.
        //extras - play games and have the monster react to the win/loss ratio, show prgress of monster over time, select new monsters.
            //raise new monsters, fire specilized errors pending different actions.
        OpeningPageGUI opGUI = new OpeningPageGUI(); //Load up the opening screen.
        MonsterSelectGUI msGUI = new MonsterSelectGUI(); // monster selection page.
        MainStageGUI mainStageGUI = new MainStageGUI(); //main stage for which the users will be able to log information in.
        //the user input page is pending changes - may move this to a dialog box instead.
        DataReviewGUI drGUI = new DataReviewGUI();
    }
}
