package fr.cnam.tp13.controllers;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.tp13.model.ObservableSalon;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.sql.Timestamp;
import java.util.Date;

public class Tp13JPanelController extends JPanel {

    public static int userNumber=1;

    private ObservableSalon myModel;

    private JLabel userLabel;
    private JTextField userMessageField;
    private JButton okButton;



    public Tp13JPanelController(ObservableSalon a_myModel) {
        this.myModel = a_myModel;
        this.userLabel = new JLabel("User "+(Tp13JPanelController.userNumber++)+":");
        this.userMessageField = new JTextField();
        this.userMessageField.setColumns(35);
        this.okButton = new JButton("ok");
        okButton.addActionListener(this::updateMode);

        /*Clear the current text to prepare next user message typing*/



        /*if user wants to send message by just pressing Enter key*/
        userMessageField.addActionListener(e -> okButton.doClick());

        /*adding my Graphical elements*/
        this.add(this.userLabel, BorderLayout.WEST);
        this.add(this.userMessageField,BorderLayout.CENTER);
        this.add(this.okButton,BorderLayout.EAST);
    }

    private void updateMode(ActionEvent actionEvent) {

        //Date object
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        System.out.println("Current Time Stamp: "+ts);

        this.myModel.addMessage(ts+"\t"+this.userLabel.getText()+userMessageField.getText()+DebugOnOFF.newline);
        this.userMessageField.setText("");
    }
}
