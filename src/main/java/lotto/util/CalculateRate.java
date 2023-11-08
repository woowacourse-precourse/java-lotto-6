package lotto.util;

public class CalculateRate {

    public static Double getTotalRate(int money, int totalReward) {
        double totalRate = ((double) totalReward / money) * 100;
        return totalRate;
    }
}
