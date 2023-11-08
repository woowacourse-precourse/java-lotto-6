package lotto.model;

import java.text.NumberFormat;
import java.util.Locale;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final long price;
    private static final String PARAMETER_ERROR = "주어진 순위 조건이 틀렸습니다.";
    Ranking(int matchCount, boolean bonusMatch, long price) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.price = price;
    }

    public static Ranking getRanking(int matchCount, boolean bonusMatch) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchCount == matchCount && ranking.bonusMatch == bonusMatch) {
                return ranking;
            }
        }
        throw new IllegalArgumentException(PARAMETER_ERROR);
    }

    public PriceMoney calculateCurrentPrice(int count) {
        PriceMoney priceMoney = new PriceMoney(price);
        return priceMoney.mulByEa(count);
    }

    @Override
    public String toString() {
        NumberFormat numberFormatUS = NumberFormat.getNumberInstance(Locale.US);
        String formattedNumber = numberFormatUS.format(price);
        return String.format("%d개 일치 (%s)", matchCount, formattedNumber);
    }
}
