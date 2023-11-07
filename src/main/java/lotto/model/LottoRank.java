package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    NOTHING(0, "", 0),
    FIFTH(3, "5,000", 0),
    FOURTH(4, "50,000", 0),
    THIRD(5, "1,500,000", 0),
    SECOND(5, "30,000,000", 0),
    FIRST(6, "2,000,000,000", 0);

    private final Integer matchingCount;
    private final String prizeAmount;
    private Integer winningCount;

    LottoRank(Integer matchingCount, String prizeAmount, Integer winningCount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.winningCount = winningCount;
    }

    public static void increaseWinningCountByMatchingCount(MatchResult matchingResult) {

        if(isSecondMatchCase(matchingResult)) {
            SECOND.increaseWinningCount();
            return;
        }
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchingCount
                        .equals(matchingResult.matchingCount()))
                .findFirst()
                .orElse(NOTHING)
                .increaseWinningCount();
    }

    public Integer getWinningCount() {
        return this.winningCount;
    }

    public Integer getMatchingCount() {
        return matchingCount;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public Long getProfit() {
        if (prizeAmount.isEmpty()) {
            return 0L; // 수익이 없는 경우
        }

        long amount = Long.parseLong(prizeAmount.replace(",", "")); // 숫자로 변환, 쉼표 제거
        return amount * winningCount;
    }

    private void increaseWinningCount() {
        this.winningCount++;
    }

    private static boolean isSecondMatchCase(MatchResult matchingResult) {
        return matchingResult.matchingCount() == 5 && matchingResult.isMatchBonusBall();
    }
}
