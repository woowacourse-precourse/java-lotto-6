package lotto.domain;

import lotto.util.io.InputUtils;
import lotto.util.io.OutputUtils;

public class Raffle {

    public int getValidPurchaseAmount() {
        int money;
        while (true) {
            try {
                OutputUtils.printPurchaseAmountInputMessage();
                money = InputUtils.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }
}
