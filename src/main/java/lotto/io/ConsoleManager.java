package lotto.io;

import lotto.domain.lotto.Price;

import static lotto.util.StringConverter.toLong;

public class ConsoleManager {
    private final View view;

    public ConsoleManager(View view) {
        this.view = view;
    }

    public Price getPrice() {
        while (true) {
            String value = view.readPurchasePrice();
            try {
                return new Price(toLong(value));
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

}
