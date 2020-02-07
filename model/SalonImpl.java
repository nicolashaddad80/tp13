package fr.cnam.tp13.model;

import fr.cnam.cour11.DebugOnOFF;

import java.util.TreeSet;

public class SalonImpl extends TreeSet<String> implements Salon{


    public SalonImpl() {
        super();
    }

    @Override
    public void addMessage(String a_message) {

        this.add(a_message);
        if (DebugOnOFF.DEBUG_ON) System.out.println("Added Message:"+a_message+"\n");

    }

}
