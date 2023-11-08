package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    NON_RANKING(0, 0, 0);

    private final Integer matchNumbers;
    private final Integer matchBonus;
    private final Integer prizeAmount;

    Ranking(Integer matchNumbers,
            Integer matchBonus,
            Integer prizeAmount) {
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Ranking compareRanking(Integer matchNumbers, Integer matchBonus) {

        boolean isBonusEffective = (matchNumbers == 5);

        if (isBonusEffective) {
            return matchNumbersAndBonus(matchNumbers, matchBonus);
        }
        return matchNumbers(matchNumbers);
    }

    private static Ranking matchNumbers(Integer matchNumbers) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumbers.equals(matchNumbers))
                .findFirst()
                .orElse(NON_RANKING);
    }

    private static Ranking matchNumbersAndBonus(Integer matchNumbers, Integer matchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumbers.equals(matchNumbers) && ranking.matchBonus.equals(matchBonus))
                .findFirst()
                .orElse(NON_RANKING);
    }

    public Integer getPrizeMoney() {
        return prizeAmount;
    }

}
