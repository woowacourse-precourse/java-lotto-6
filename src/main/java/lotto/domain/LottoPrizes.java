package lotto.domain;

import static lotto.constant.Constant.ZERO_COUNT;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public enum LottoPrizes {
    THREE_NUMBERS_MATCHED("3개 일치", new BigDecimal(5_000)),
    FOUR_NUMBERS_MATCHED("4개 일치", new BigDecimal(50_000)),
    FIVE_NUMBER_MATCHED("5개 일치", new BigDecimal(1_500_000)),
    FIVE_NUMBER_AND_BONUS_MATCHED("5개 일치, 보너스 볼 일치", new BigDecimal(30_000_000)),
    SIX_NUMBER_MATCHED("6개 일치", new BigDecimal(2_000_000_000));

    private static final String WON = "원";
    private static final String DECIMAL_FORMAT = "###,###";
    private final String term;
    private final BigDecimal winningAmount;

    LottoPrizes(String term, BigDecimal winningAmount) {
        this.term = term;
        this.winningAmount = winningAmount;
    }

    public String getTerm() {
        return term;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    public String getParsedWinningAmount() {
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        return formatter.format(getWinningAmount()) + WON;
    }

    public static Map<LottoPrizes, Integer> getPrizesCountMap() {
        Map<LottoPrizes, Integer> prizesCountsMap = new EnumMap<>(LottoPrizes.class);
        for (LottoPrizes lottoPrizes : LottoPrizes.values()) {
            prizesCountsMap.put(lottoPrizes, ZERO_COUNT);
        }
        return prizesCountsMap;
    }
}
