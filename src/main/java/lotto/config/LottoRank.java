package lotto.config;

public enum LottoRank {

    THIRD(3, 4, 5000, "3개 일치 (5,000원) -"), // 3개 일치 (5,000원)
    FOURTH(4, 3, 50000, "4개 일치 (50,000원) -"), // 4개 일치 (50,000원)
    FIFTH(5, 2, 1500000, "5개 일치 (1,500,000원) -"), // 5개 일치 (1,500,000원)
    BONUS(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"), // 5개 일치, 보너스 볼 일치 (30,000,000원)
    FIRST(6, 0, 2000000000, "6개 일치 (2,000,000,000원) -");// 6개 일치 (2,000,000,000원)

    private final int matchingNumbers;
    private final int rank;
    private final long money;
    private final String description;

    LottoRank(int matchingNumbers, int rank, long money, String description) {
        this.matchingNumbers = matchingNumbers;
        this.rank = rank;
        this.money = money;
        this.description = description;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getRank() {
        return rank;
    }

    public long getMoney() {
        return money;
    }

    public String getDescription() {
        return description;
    }
}
