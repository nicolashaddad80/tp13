package fr.cnam.tp13.application;

import fr.cnam.cour11.controllers.PanelController;

import fr.cnam.tp13.controllers.Tp13JPanelController;
import fr.cnam.tp13.model.Salon;
import fr.cnam.tp13.view.Tp13JPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TchatGui {

    private JFrame frame = new JFrame("Tchat Gui Application");
    /*Create instance of Model*/
    private Salon myModel;
    private Tp13JPanelView myTchatView;
    private Tp13JPanelController myTchatController;

    public TchatGui(Salon a_myModel) {
        this.myModel = a_myModel;
        this.myTchatView = new Tp13JPanelView(myModel);
        this.myTchatController = new Tp13JPanelController(myModel);
        JButton myExitButton = new JButton("Fermer");

        Container content = this.frame.getContentPane();
        content.setLayout(new FlowLayout());
        /*Adding Exit Button*/
        content.add(myExitButton);
        /* Adding Vue Panel Part */
        content.add(this.myTchatView);
        /* Adding controller Panel Part */
        content.add(myTchatController);
        myExitButton.addActionListener(e -> myExit());

    }

    public void start() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
        this.frame.setSize(800, 700);
        this.frame.setVisible(true);
    }

    private void myExit() {
        this.myTchatView.destroy();
        System.out.println("Thank you Using this Application");
        this.frame.dispose();
        if (this.myModel.countObservers() == 0)
            System.exit(0);
    }
}

