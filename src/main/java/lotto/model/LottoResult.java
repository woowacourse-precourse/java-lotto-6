package lotto.model;

import java.util.HashMap;

public class LottoResult {

    private static final int FIRST_MONEY = 2000000000;
    private static final int SECOND_MONEY = 30000000;
    private static final int THIRD_MONEY = 1500000;
    private static final int FOURTH_MONEY = 50000;
    private static final int FIFTH_MONEY = 5000;
    private static final int FIRST_NUMBER_OF_SAME = 6;
    private static final int SECOND_NUMBER_OF_SAME = 5;
    private static final int THIRD_NUMBER_OF_SAME = 5;
    private static final int FORUTH_NUMBER_OF_SAME = 4;
    private static final int FIFTH_NUMBER_OF_SAME = 3;

    private static HashMap<Integer, Integer> result = new HashMap<>();
    public LottoResult(HashMap result) {
        this.result = result;
    }

    public enum PrizeMoney {
        FIRST(FIRST_MONEY), SECOND(SECOND_MONEY), THIRD(THIRD_MONEY), FOURTH(FOURTH_MONEY), FIFTH(FIFTH_MONEY);

        private final int money;

        PrizeMoney(int money) {
            this.money = money;
        }

        public int calculateFare(int count) {
            return count * money;
        }
    }

    public static HashMap statistics(int sameCount, Boolean bonusCheck) {
        if (sameCount == FIFTH_NUMBER_OF_SAME) {
            int num = result.get(FIFTH_NUMBER_OF_SAME);
            num++;
            result.put(FIFTH_NUMBER_OF_SAME,num);
        }
        if (sameCount == FORUTH_NUMBER_OF_SAME) {
            int num = result.get(FORUTH_NUMBER_OF_SAME);
            num++;
            result.put(FORUTH_NUMBER_OF_SAME,num);
        }
        if (sameCount == THIRD_NUMBER_OF_SAME && bonusCheck) {
            int num = result.get(THIRD_NUMBER_OF_SAME);
            num++;
            result.put(THIRD_NUMBER_OF_SAME,num);
        }
        if (sameCount == SECOND_NUMBER_OF_SAME && bonusCheck) {
            int num = result.get(SECOND_NUMBER_OF_SAME + 1);
            num++;
            result.put(SECOND_NUMBER_OF_SAME + 1,num);
        }
        if (sameCount == FIRST_NUMBER_OF_SAME) {
            int num = result.get(FIRST_NUMBER_OF_SAME + 1);
            num++;
            result.put(FIRST_NUMBER_OF_SAME + 1,num);
        }
        return result;
    }

    public static double calculateProfit(int purchase) {
        double allMoney = 0;
        for (PrizeMoney p : PrizeMoney.values()) {
            allMoney += p.calculateFare(result.get(7 - p.ordinal()));
        }
        return allMoney / (purchase * 10);
    }
}
