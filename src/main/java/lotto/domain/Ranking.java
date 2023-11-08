package lotto.domain;

public enum Ranking {
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    THIRD("5개 일치 (1,500,000원) - ", 1500000),
    FOURTH("4개 일치 (50,000원) - ", 50000),
    FIFTH("3개 일치 (5,000원) - ", 5000);

    private final String message;
    private final int rankingAmount;

    Ranking(String message, int rankingAmount) {
        this.message = message;
        this.rankingAmount = rankingAmount;
    }

    public String getMessage() {
        return this.message;
    }

    public int getRankingAmount() {
        return this.rankingAmount;
    }
}

