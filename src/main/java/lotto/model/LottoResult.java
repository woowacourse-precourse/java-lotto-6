package lotto.model;

import java.util.HashMap;

public class LottoResult {

    private static final int NUMBER_OF_WINNING_CASE = 5;

    private static HashMap<Integer, Integer> result = new HashMap<>();

    public enum PrizeMoney {
        FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000),
        FOURTH(4, 50000), FIFTH(3, 5000);

        private final int numberOfSame;
        private final int money;

        PrizeMoney(int numberOfSame, int money) {
            this.numberOfSame = numberOfSame;
            this.money = money;
        }

        public int getNumberOfSame() {
            return numberOfSame;
        }

        public int calculateFare(int count) {
            return count * money;
        }
    }

    public static void initialize() {
        for (int i = PrizeMoney.FIFTH.getNumberOfSame(); i < NUMBER_OF_WINNING_CASE + PrizeMoney.FIFTH.getNumberOfSame(); i++) {
            result.put(i, 0);
        }
    }

    public static HashMap statistics(int sameCount, Boolean bonusCheck) {
        if (sameCount == PrizeMoney.FIFTH.getNumberOfSame()) {
            int num = result.get(PrizeMoney.FIFTH.getNumberOfSame());
            num++;
            result.put(PrizeMoney.FIFTH.getNumberOfSame(), num);
        }
        if (sameCount == PrizeMoney.FOURTH.getNumberOfSame()) {
            int num = result.get(PrizeMoney.FOURTH.getNumberOfSame());
            num++;
            result.put(PrizeMoney.FOURTH.getNumberOfSame(), num);
        }
        if (sameCount == PrizeMoney.THIRD.getNumberOfSame()) {
            if (bonusCheck) {
                int num = result.get(PrizeMoney.SECOND.getNumberOfSame() + 1);
                num++;
                result.put(PrizeMoney.SECOND.getNumberOfSame() + 1, num);
            }
            if (!bonusCheck) {
                int num = result.get(PrizeMoney.THIRD.getNumberOfSame());
                num++;
                result.put(PrizeMoney.THIRD.getNumberOfSame(), num);
            }
        }
        if (sameCount == PrizeMoney.FIRST.getNumberOfSame()) {
            int num = result.get(PrizeMoney.FIRST.getNumberOfSame() + 1);
            num++;
            result.put(PrizeMoney.FIRST.getNumberOfSame() + 1, num);
        }
        return result;
    }

    public static double calculateProfit(int purchase) {
        double allMoney = 0;
        for (PrizeMoney p : PrizeMoney.values()) {
            allMoney += p.calculateFare(result.get(PrizeMoney.FIRST.getNumberOfSame() + 1 - p.ordinal()));
        }
        return allMoney / (purchase * 10);
    }
}