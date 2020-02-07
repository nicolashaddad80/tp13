package fr.cnam.tp13.view;



import fr.cnam.tp12.mypatterns.MyObserver;
import fr.cnam.tp12.mypatterns.OptimizedClass;
import fr.cnam.tp13.model.ObservableSalon;

import javax.swing.*;


public class Tp13JPanelView extends JPanel implements OptimizedClass {

    /*Attributes*/

    /*Vue Model*/

    /**
     * My Model is a simple Observable counter that I will Observe by registering me to him
     */
    private ObservableSalon myModel;
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
    public Tp13JPanelView(ObservableSalon a_myModel) {
        this.myModel = a_myModel;
        this.myModelObserver = this::updateMyModelValue;
        this.myModel.addObserver(myModelObserver);

        this.displaySalon  = new JTextArea();
        this.displaySalon.setLineWrap(true);
        this.displaySalon.setWrapStyleWord(true);
        this.displaySalon.setEditable(false);
        this.displaySalon.setColumns(45);
        this.displaySalon.setRows(40);
        this.displaySalon.setAutoscrolls(true);

        JScrollPane salonScrollPane = new JScrollPane(this.displaySalon);

        salonScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(salonScrollPane);

        this.LoadMyModel();
    }

    private void LoadMyModel() {

        for(String message: this.myModel) this.displaySalon.append(message);
    }

    private void updateMyModelValue() {
        if(this.myModel.size() <=0) System.out.println("EROOR: Empty set");
        this.displaySalon.append(this.myModel.last());
    }

    /**
     * Implementing OptimizedClass as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */

    @Override
    public void destroy() {
        this.myModel.deleteObserver(this.myModelObserver);
    }

}
