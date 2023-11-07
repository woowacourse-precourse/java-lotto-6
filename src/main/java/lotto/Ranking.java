package lotto;

import java.text.DecimalFormat;

public enum Ranking {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchingNumber;
    private final boolean shouldMatchingBonusNumber;
    private final int price;

    Ranking(final int matchingNumber, final boolean shouldMatchingBonusNumber, final int price) {
        this.matchingNumber = matchingNumber;
        this.shouldMatchingBonusNumber = shouldMatchingBonusNumber;
        this.price = price;
    }

    public static Ranking valudOf(int count, boolean hasBonusNumber) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.isEqual(count, hasBonusNumber))
                return ranking;
        }
        return null;
    }

    private boolean isEqual(int count, boolean hasBonusNumber) {
        if (count == 5)
            return this.matchingNumber == count && this.shouldMatchingBonusNumber == hasBonusNumber;
        return this.matchingNumber == count;
    }

    public String getResult(int time) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String bonusMessage = "";
        if (shouldMatchingBonusNumber)
            bonusMessage = ", 보너스 볼 일치";
        return String.format("%d개 일치%s (%s원) - %d개\n", matchingNumber, bonusMessage, formatter.format(price), time);
    }

    public int getPriceByTime(int time) {
        return price * time;
    }
}
