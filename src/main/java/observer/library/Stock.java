package observer.library;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Stock implements Observer {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void update(String symbol, double price) {
        support.firePropertyChange("price", this.price, price);
        this.price = price;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
