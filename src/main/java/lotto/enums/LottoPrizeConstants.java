package lotto.enums;


import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoPrizeConstants {
    SIX_MATCH_PRIZE(6, 2000000000),
    BONUS_PRIZE(5, 30000000),
    FIVE_MATCH_PRIZE(5, 1500000),
    FOUR_MATCH_PRIZE(4, 50000),
    THREE_MATCH_PRIZE(3, 5000),
    TWO_MATCH_PRIZE(2, 0),
    ONE_MATCH_PRIZE(1, 0),
    NO_MATCH_PRIZE(0, 0);
    private final int matchingNumber;
    private final int prizeMoney;
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    LottoPrizeConstants(int matchingNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.prizeMoney = prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeByDecimal() {
        return decimalFormat.format(prizeMoney);
    }

    public static LottoPrizeConstants getPrizeByMatchingNumber(int matchingNumber) {
        return Arrays.stream(values())
                .filter(prizeConstant -> prizeConstant.matchingNumber == matchingNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[Error] 일치하는 숫자의 입력이 올바르지 않습니다."));
    }
}
