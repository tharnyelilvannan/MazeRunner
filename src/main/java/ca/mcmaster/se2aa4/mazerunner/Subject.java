package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private static final Logger logger = LogManager.getLogger();

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyAllObservers() {

        try {
            for (Observer observer: observers) {
                observer.update();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
