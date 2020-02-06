package fr.cnam.tp13.model;

import fr.cnam.cour11.mydesignpatterns.observer.MyObservable;

import java.util.Iterator;

public interface Salon extends MyObservable {

    void addMessage(String a_message);

    Iterator<String>  getIterator();

}
