package lotto;

import java.util.Optional;

public enum LottoWinningSpec {
    FIFTH_PRIZE(5, 3,"3개 일치", "5,000원", 5000),
    FOURTH_PRIZE(4, 4,"4개 일치", "50,000원", 50000),
    THIRD_PRIZE(3, 5,"5개 일치", "1,500,000원", 1500000),
    SECOND_PRIZE(2, 5,"5개 일치, 보너스 볼 일치", "30,000,000원", 30000000),
    FIRST_PRIZE(1, 6,"6개 일치", "2,000,000,000원", 2000000000);

    private final int rank;
    private final int matchingCount;
    private final String matchingRefer;
    private final String prizeRefer;
    private final int prizeMoney;

    LottoWinningSpec(int rank, int matchingCount, String matchingRefer, String prizeRefer, int prizeMoney) {
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.matchingRefer = matchingRefer;
        this.prizeRefer = prizeRefer;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public static Optional<LottoWinningSpec> getRankByMatchingCount(int matchingCount) {
        for (LottoWinningSpec spec : LottoWinningSpec.values()) {
            if (spec.getMatchingCount() == matchingCount) {
                return Optional.of(spec);
            }
        }
        return Optional.empty();
    }
    public String getMatchingRefer() {
        return matchingRefer;
    }
    public String getPrizeRefer() {
        return prizeRefer;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinInformation() {
        return getMatchingRefer() + " " + getPrizeRefer();
    }
}
