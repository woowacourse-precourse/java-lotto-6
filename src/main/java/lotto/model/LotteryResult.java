package lotto.model;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import lotto.model.enums.WinningMoney;

public class LotteryResult {

    private static final String PROFIT_PERCENTAGE_FORMAT = "#,##0.0";

    private final Map<WinningMoney, Integer> store;

    public LotteryResult(Map<WinningMoney, Integer> store) {
        this.store = store;
    }

    public String getProfitPercentage(PurchaseMoney purchaseMoney) {
        double profitPercentage = (double) calculateProfit() / purchaseMoney.getPurchaseMoney() * 100;
        return new DecimalFormat(PROFIT_PERCENTAGE_FORMAT).format(profitPercentage);
    }

    public Map<WinningMoney, Integer> getStore() {
        return Collections.unmodifiableMap(store);
    }

    private long calculateProfit() {
        long sum = 0;
        for (WinningMoney key : WinningMoney.values()) {
            sum += calculateMatches(key);
        }
        return sum;
    }

    private long calculateMatches(WinningMoney winningMoney) {
        if (store.containsKey(winningMoney)) {
            return WinningMoney.calculateMoney(winningMoney, store.get(winningMoney));
        }
        return 0;
    }
}
