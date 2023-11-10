package lotto.constants;

public enum LottoRank {

    THIRD(3, 5, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 4, 50000, "4개 일치 (50,000원) - %d개"),
    FIFTH(5, 3, 1500000, "5개 일치 (1,500,000원) - %d개"),
    BONUS(5, 2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 1, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

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
