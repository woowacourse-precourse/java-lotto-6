package lotto;

import static lotto.views.UserInput.readPurchasePrice;
import static lotto.views.UserOutput.askPurchasePrice;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        askPurchasePrice();
        Integer purchasePrice = readPurchasePrice();
    }
}
