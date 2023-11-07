package lotto.model;

import java.util.HashMap;

public class LottoResult {

    private static HashMap<Integer, Integer> result = new HashMap<>();
    public LottoResult(HashMap result) {
        this.result = result;
    }

    public enum PrizeMoney {
        FIFTH(5000), FOURTH(50000), THIRD(1500000), SECOND(30000000), FIRST(2000000000);

        private final int money;

        PrizeMoney(int money) {
            this.money = money;
        }

        public int calculateFare(int count) {
            return count * money;
        }
    }

    public static HashMap statistics(int count, int choice) {
        if (count == 3) {
            int num = result.get(4);
            num++;
            result.put(4,num);
        }
        if (count == 4) {
            int num = result.get(3);
            num++;
            result.put(3,num);
        }
        if (count == 5 && choice == 1) {
            int num = result.get(1);
            num++;
            result.put(1,num);
        }
        if (count == 5 && choice == 0) {
            int num = result.get(2);
            num++;
            result.put(2,num);
        }
        if (count == 6) {
            int num = result.get(0);
            num++;
            result.put(0,num);
        }
        return result;
    }

    public static double calculateProfit(int purchase) {
        double allMoney = 0;
        for (PrizeMoney p : PrizeMoney.values()) {
            allMoney += p.calculateFare(result.get(4 - p.ordinal()));
        }
        return allMoney / (purchase * 10);
    }
}
