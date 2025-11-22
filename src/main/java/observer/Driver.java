package observer;

import observer.library.Stock;
import observer.library.StockObserver;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        String symbol = "NVDA";
        double lastPrice = 178.88;
        Stock stock = new Stock(symbol, lastPrice);
        StockObserver stockObserver = new StockObserver();
        double nextPrice;
        Random random = new Random();

        stock.addPropertyChangeListener(stockObserver);

        for (int i = 0; i < 10; i++) {
            nextPrice = random.nextDouble(170.00, 190.00);
            stock.update(symbol, (Math.round(nextPrice * 100)/100));
        }

        stockObserver.printUpdate(symbol);
    }
}
