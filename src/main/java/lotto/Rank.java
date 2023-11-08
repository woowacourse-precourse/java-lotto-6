package lotto;

import java.text.NumberFormat;
import java.util.Map;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0);


    public int matchingNumberCount;
    public int prizeAmount;
    private boolean isRequireBonus;

    Rank(int matchingNumberCount, boolean isRequireBonus, int prizeAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.isRequireBonus = isRequireBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Rank checkRank(int matchingNumberCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchingNumberCount == matchingNumberCount
                    && (!rank.isRequireBonus || matchBonus)) {
                return rank;
            }
        }

        return NOTHING;
    }

    public String getFormattedRankInfo() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        String formattedNumber = numberFormat.format(this.prizeAmount);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.matchingNumberCount);
        stringBuilder.append("개 일치");

        if(this.isRequireBonus) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        stringBuilder.append(" (");
        stringBuilder.append(formattedNumber);
        stringBuilder.append("원)");

        return stringBuilder.toString();
    }

}
