package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyTickets {
    Map<Long, List> LotteryNumbers = new HashMap<>();
    public BuyTickets(String PurchaseAmount) {
    }

    public Map<Long, List> getLotteryNumbers() {
        return LotteryNumbers;
    }
}
