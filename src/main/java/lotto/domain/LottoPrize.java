package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NONE(0, false, 0, "", 0),
    FIFTH(3, false, 5000, "(5,000원)", 5),
    FOURTH(4, false, 50000, "(50,000원)", 4),
    THIRD(5, false, 1500000, "(1,500,000원)", 3),
    SECOND(5, true, 30000000, "(30,000,000원)", 2),
    FIRST(6, false, 2000000000, "(2,000,000,000원)", 1);

    private final int matchesNumber;

    private final boolean bonusNumber;

    private final int prizeMoney;

    private final String prizeMoneyMessage;
    private final int prize;

    LottoPrize(int matchesNum, boolean bonusNumber, int prizeMoney, String prizeMoneyMessage, int prize) {
        this.matchesNumber = matchesNum;
        this.bonusNumber = bonusNumber;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyMessage = prizeMoneyMessage;
        this.prize = prize;
    }

    public static LottoPrize getLottoPrizeByMatchesNumber(int matchesNumber, boolean bonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.matchesNumber == matchesNumber)
                .filter(lottoPrize -> lottoPrize.bonusNumber == bonusNumber)
                .findFirst()
                .orElse(NONE);

    }

    public static LottoPrize getLottoPrizeByPrize(int prize){
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getPrize() == prize)
                .findFirst()
                .get();
    }

    public int getMatchesNumber() {
        return matchesNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeMoneyMessage() {
        return prizeMoneyMessage;
    }
}
