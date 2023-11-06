package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(1, 6, false, "2,000,000,000"),
    SECOND(2, 5, true, "30,000,000"),
    THIRD(3, 5, false, "1,500,000"),
    FOURTH(4, 4, false, "50,000"),
    FIFTH(5, 3, false, "5,000"),
    NOT_PRIZE(6, 2, false, "0");

    private final Integer rank;
    private final Integer matchCount;
    private final Boolean matchBonus;
    private final String price;

    Ranking(Integer rank, Integer matchCount, Boolean matchBonus, String price) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Ranking getRanking(Integer matchCount, Boolean matchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount.equals(matchCount) && ranking.matchBonus.equals(matchBonus))
                .findFirst()
                .orElse(NOT_PRIZE);
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        if (rank == 2) return String.format(Constants.PRINT_SECOND_PLACE, matchCount, price);
        return String.format(Constants.PRINT_RANKING, matchCount, price);
    }
}
