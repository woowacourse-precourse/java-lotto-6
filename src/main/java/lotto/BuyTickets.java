package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyTickets {
    Map<Long, List> LotteryNumbers = new HashMap<>();

    public BuyTickets(String purchaseAmount) {
        int validated = validate(purchaseAmount);
    }

    private int validate(String stringPurchaseAmount) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
        return validateMultipleOfThousand(purchaseAmount);
    }

    private int validateMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 == 0) {
            throw new IllegalStateException();
        }
        return purchaseAmount / 1000;
    }

    public Map<Long, List> getLotteryNumbers() {
        return LotteryNumbers;
    }
}
