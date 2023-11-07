package lotto;


import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoPrizeConstants {
    SIX_MATCH_PRIZE_MONEY(6, 2000000000),
    BONUS_PRIZE_MONEY(5, 30000000),
    FIVE_MATCH_PRIZE_MONEY(5, 1500000),
    FOUR_MATCH_PRIZE_MONEY(4, 50000),
    THREE_MATCH_PRIZE_MONEY(3, 5000);
    private final int matchingNumber;
    private final int prize;
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    LottoPrizeConstants(int matchingNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeByDecimal() {
        return decimalFormat.format(prize);
    }

//    public static int getPrizeByMatchingNumber(int matchingNumber) {
//        return Arrays.stream(values())
//                .filter(prizeConstant -> prizeConstant.matchingNumber == matchingNumber)
//                .mapToInt(prizeConstant -> prizeConstant.prize)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException());
//    }
}
