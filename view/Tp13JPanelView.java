package fr.cnam.tp13.view;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.cour11.mydesignpatterns.observer.MyObserver;
import fr.cnam.cour11.mydesignpatterns.observer.OptimizedClass;
import fr.cnam.tp13.model.Salon;

import javax.swing.*;
import java.util.Iterator;

public class Tp13JPanelView extends JPanel implements OptimizedClass {

    /*Attributes*/

    /*Vue Model*/

    /**
     * My Model is a simple Observable counter that I will Observe by registering me to him
     */
    private Salon myModel;
    private MyObserver myModelObserver;

    /**
     * My Model is a simple Counter use simple swing label to show it in the screen
     */
    private JTextArea displaySalon;

    /**
     * Constructor
     *
     * @param a_myModel: A simple counter as a Model for me.
     */
    public Tp13JPanelView(Salon a_myModel) {
        this.myModel = a_myModel;
        this.myModelObserver = this::updateMyModelValue;
        this.myModel.registerObserver(myModelObserver);
        this.displaySalon  = new JTextArea();
        this.add(this.displaySalon);

        this.LoadMyModel();
    }

     private void LoadMyModel() {
        //TODO change Model to be able to do for each on the model as specified

        while(this.myModel.getIterator().hasNext()) this.displaySalon.append((String)this.myModel.getIterator().next());
    }

    private void updateMyModelValue() {
        //TODO change Model to be able to do for each on the model as specified
        Iterator<String>  myModelIterator=this.myModel.getIterator();
        String lastMessage="";
        while(this.myModel.getIterator().hasNext()) lastMessage = myModelIterator.next();
        this.displaySalon.append(lastMessage);
    }

    /**
     * Implementing OptimizedClass as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */

    @Override
    public void destroy() {
        this.myModel.unregisterObserver(this.myModelObserver);
    }

}
