package lotto.domain;

import lotto.dto.LottoMatchResponse;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final String NUMBERS_MATCH_COUNT_ERROR = "[ERROR] 로또 번호 일치 개수는 0~6 범위여야 합니다.";
    private static final int MIN_WINNING_COUNT = 3;

    private final int matchingCount;
    private final int winningAmount;

    Prize(int matchingCount, int winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    public static Prize valueOf(LottoMatchResponse matchResponse) {
        int matchingCount = matchResponse.getMatchingCount();

        if (isSecond(matchingCount, matchResponse.isBonus())) {
            return SECOND;
        }

        Prize prize = valueOf(matchingCount);
        return prize;
    }

    private static Prize valueOf(int matchingCount) {
        for (Prize prize : values()) {
            if (matchingCount < MIN_WINNING_COUNT) {
                return NONE;
            }
            if (isEqualMatchingCount(matchingCount, THIRD.matchingCount)) {
                return THIRD;
            }
            if (isEqualMatchingCount(matchingCount, prize.matchingCount)) {
                return prize;
            }
        }
        throw new IllegalArgumentException(NUMBERS_MATCH_COUNT_ERROR);
    }

    private static boolean isEqualMatchingCount(int matchingCount, int otherMatchingCount) {
        return matchingCount == otherMatchingCount;
    }

    private static boolean isSecond(int matchingCount, boolean bonusMatch) {
        if (matchingCount == SECOND.matchingCount && bonusMatch) {
            return true;
        }
        return false;
    }

    public long calculateAmount(int winningCount) {
        return (long) this.winningAmount * winningCount;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }
}