package lotto.model;

import java.util.Map;

public class EarnMoney {
    public static int getEarnMoney(Map<String, Integer> result) {
        final int THREE_MONEY = 5000;
        final int FOUR_MONEY = 50000;
        final int FIVE_MONEY = 1500000;
        final int FIVE_BONUS_MONEY = 30000000;
        final int SIX_MONEY = 2000000000;
        int earnMoney = 0;
        for (String key : result.keySet()) {
            if (key.equals("three")) {
                earnMoney += (result.get(key) * THREE_MONEY);
            }
            if (key.equals("four")) {
                earnMoney += (result.get(key) * FOUR_MONEY);
            }
            if (key.equals("five")) {
                earnMoney += (result.get(key) * FIVE_MONEY);
            }
            if (key.equals("fiveBonus")) {
                earnMoney += (result.get(key) * FIVE_BONUS_MONEY);
            }
            if (key.equals("six")) {
                earnMoney += (result.get(key) * SIX_MONEY);
            }
        }

        return earnMoney;
    }
}
