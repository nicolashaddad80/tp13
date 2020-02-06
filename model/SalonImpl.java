package fr.cnam.tp13.model;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.cour11.mydesignpatterns.observer.MyObservableImp1;

import java.util.ArrayList;
import java.util.Iterator;

public class SalonImpl extends MyObservableImp1 implements Salon{

    private ArrayList<String> myMessages=new ArrayList<>();

    @Override
    public void addMessage(String a_message) {
        this.myMessages.add(a_message);
        if (DebugOnOFF.DEBUG_ON) System.out.println("Added Message:"+a_message+"\n");
        this.notifyObservers();
    }

    @Override
    public Iterator<String> getIterator() {
        return this.myMessages.iterator();
    }
}
