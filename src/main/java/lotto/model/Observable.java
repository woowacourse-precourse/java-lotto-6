package lotto.model;

import lotto.view.Observer;

abstract public class Observable {
    protected Observer observer;

    public void subscribe(Observer observer) {
        this.observer = (observer);
    }

    abstract public void unsubscribe(Observer observer);

    abstract public void notifyObserver(Object data);
}