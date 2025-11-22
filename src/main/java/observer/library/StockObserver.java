package observer.library;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class StockObserver implements PropertyChangeListener {
    private ArrayList<Double> prices = new ArrayList<Double>();

    public void printUpdate(String symbol) {
        double difference;
        double previousPrice;

        for (int i = 0; i < prices.size(); i++) {
            if(i == 0) {
                previousPrice = 0.00;
            } else {
                previousPrice = prices.get(i-1);
            }

            if (this.prices.get(i) > previousPrice) {
                difference = this.prices.get(i) - previousPrice;
                System.out.println("Price of " + symbol + " increased by " + difference + " from $" + previousPrice + " and is now $" + this.prices.get(i));
            } else if (this.prices.get(i) < previousPrice) {
                difference = previousPrice - this.prices.get(i);
                System.out.println("Price of " + symbol + " decreased by " + difference + " from $" + previousPrice + " and is now $" + this.prices.get(i));
            } else {
                System.out.println("There was no change in " + symbol + " price");
            }
        }


    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.prices.add((double) event.getNewValue());
    }
}
