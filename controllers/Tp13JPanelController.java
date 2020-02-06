package fr.cnam.tp13.controllers;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.tp13.model.Salon;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Tp13JPanelController extends JPanel {

    public static int userNumber=1;

    private Salon myModel;

    private JLabel userLabel;
    private JTextField userMessageField;
    private JButton okButton;



    public Tp13JPanelController(Salon a_myModel) {
        this.myModel = a_myModel;
        this.userLabel = new JLabel("User "+(Tp13JPanelController.userNumber++)+":");
        this.userMessageField = new JTextField();
        this.userMessageField.setSize(600,20);
        this.okButton = new JButton("ok");
        okButton.addActionListener(this::updateMode);

        /*Clear the current text to prepare next user message typing*/



        /*if user wants to send message by just pressing Enter key*/
        userMessageField.addActionListener(e -> okButton.doClick());

        /*adding my Graphical elements*/
        this.add(this.userLabel);
        this.add(this.userMessageField);
        this.add(this.okButton);
    }

    private void updateMode(ActionEvent actionEvent) {
        this.myModel.addMessage(this.userLabel.getText()+userMessageField.getText()+DebugOnOFF.newline);
        this.userMessageField.setText("");
    }
}
