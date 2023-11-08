package lotto.domain;

import static lotto.constant.WinningConstant.SECOND_OR_THIRD_CONDITION;
import static lotto.constant.WinningConstant.ZERO_PRIZE;

import java.util.Arrays;

/*
 *  로또 당첨에 관한 정보 담당
 * */

public enum LotteryResult {
    EIGHTH(0, 0L, ",0원"),
    SEVENTH(1, 0L, ",0원"),
    SIXTH(2, 0L, ",0원"),
    FIFTH(3, 5_000L, "5,000원"),
    FOURTH(4, 50_000L, "50,000원"),
    THIRD(5, 1_500_000L, "1,500,000원"),
    FIRST(6, 2_000_000_000L, "2,000,000,000원"),
    SECOND(5, 30_000_000L, "30,000,000원");

    private final int correctCount;
    private final Long prize;
    private final String convertedPrize;

    LotteryResult(int correctCount, Long prize, String convertedPrize) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.convertedPrize = convertedPrize;
    }

    public static LotteryResult of(int correctCount, boolean correctBonusNumber) {
        if (correctCount == SECOND_OR_THIRD_CONDITION) {
            return createSecondOrThird(correctBonusNumber);
        }
        return Arrays.stream(values())
                .filter((lotteryResult -> lotteryResult.correctCount == correctCount))
                .findFirst()
                .orElseThrow();
    }

    private static LotteryResult createSecondOrThird(boolean correctBonusNumber) {
        if (correctBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public boolean isWinning() {
        return prize > ZERO_PRIZE;
    }

    public Long getPrize() {
        return prize;
    }

    public String getConvertedPrize() {
        return convertedPrize;
    }

}


