package fr.cnam.tp13.tests;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.tp13.application.TchatGui;
import fr.cnam.tp13.model.Salon;
import fr.cnam.tp13.model.SalonImpl;


import javax.swing.*;

public class TchatGuiTest {

    public static void main(String[] args) {
        Salon myModel1 = new SalonImpl();
        SwingUtilities.invokeLater(() -> new TchatGui(myModel1).start());
        /*Launching Additional Views of same Model counter for debug purpose if DEBUG_ON seated to true*/
        if (DebugOnOFF.DEBUG_ON) for (int i = 0; i < DebugOnOFF.NB_DEBUG_PARALLEL_ADDITIONAL_VIEWS; i++)
            SwingUtilities.invokeLater(() -> new TchatGui(myModel1).start());
    }
}
