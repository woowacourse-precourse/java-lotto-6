package lotto.domain;

public enum Ranking {

    FIFTH(3, "3개 일치 (5,000원)", 5000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    THIRD(5, "5개 일치 (1,500,000원)", 1500000),
    SECOND(-1, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),

    FIRST(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int rank;
    private final String message;
    private final int money;

    Ranking(int rank, String message, int money) {
        this.rank = rank;
        this.message = message;
        this.money = money;
    }

    public static int getTotalPrizeMoney(RankingCounter rankingCounter) {
        int sum = Unit.ZERO.getValue();
        for (Ranking ranking : Ranking.values()) {
            sum += ranking.money * rankingCounter.getCount(ranking);
        }
        return sum;
    }

    public boolean isThirdRank(int rank) {
        return rank == THIRD.rank;
    }

    public int getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }
}
