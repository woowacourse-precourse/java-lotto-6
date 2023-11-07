package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    NO_MATCH(0, 0, "");

    LottoRanking(int matchingNumbers, int prizeAmount, String resultMessage) {
        this.matchingNumber = matchingNumbers;
        this.prizeAmount = prizeAmount;
        this.resultMessage = resultMessage;
    }

    private int matchingNumber;
    private int prizeAmount;
    private String resultMessage;

    public static LottoRanking valueOf(int matchingNumber, boolean isBonusInclude) {
        if (SECOND.matchNumber(matchingNumber) && isBonusInclude) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(LottoRanking -> LottoRanking.matchNumber(matchingNumber)
                        && LottoRanking != SECOND)
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean matchNumber(int matchingNumber) {
        return this.matchingNumber == matchingNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
