package lotto.model;


import java.util.Arrays;

public enum LottoReward {
    FIRST_PLACE(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE(5, 1_500_000L, "5개 일치 (1,500,000원) - "),
    FOURTH_PLACE(4, 50_000L, "4개 일치 (50,000원) - "),
    FIFTH_PLACE(3, 5_000L, "3개 일치 (5,000원) - "),
    NOTHING(0, 0, "\n");

    private final int matchNumbersCount;
    private final long winningReward;
    private final String message;
    private static final int WINNING_MIN_COUNT = 3;

    LottoReward(int matchNumbersCount, long winningReward, String message) {
        this.matchNumbersCount = matchNumbersCount;
        this.winningReward = winningReward;
        this.message = message;
    }

    public static LottoReward getReward(int matchedCount, boolean isBonusNumberMatched) {
        LottoReward lottoReward = getLottoReward(matchedCount);
        return checkIsSecondPlace(lottoReward, isBonusNumberMatched);
    }

    private static LottoReward checkIsSecondPlace(LottoReward lottoReward,
            boolean isBonusNumberMatched) {
        if (lottoReward == THIRD_PLACE) {
            if (isBonusNumberMatched) {
                return SECOND_PLACE;
            }
        }
        return lottoReward;
    }

    public int getMatchNumbersCount() {
        return matchNumbersCount;
    }

    public long getWinningReward() {
        return winningReward;
    }

    private static LottoReward getLottoReward(int matchedCount) {
        if (matchedCount < WINNING_MIN_COUNT) {
            return NOTHING;
        }

        return Arrays.stream(values())
                .filter(reward -> reward.matchNumbersCount == matchedCount)
                .reduce((first, second) -> second)
                .orElse(NOTHING);
    }

    public String getMessage() {
        return message;
    }
}
