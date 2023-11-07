package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    SIX_WINS(6, 2000000000),
    FIVE_PLUS_BONUS(5, 30000000),
    FIVE_WINS(5, 1500000),
    FOUR_WINS(4, 50000),
    THREE_WINS(3, 5000),
    NO_WINS(0, 0);

    private final int winNumber;
    private final int prize;

    Ranking(int winNumber, int prize) {
        this.winNumber = winNumber;
        this.prize = prize;
    }

    public Ranking setRanking(int winCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.checkRanking(ranking, winCount, hasBonusNumber))
                .findFirst()
                .orElse(NO_WINS);
    }

    private boolean checkRanking(Ranking ranking, int winCount, boolean hasBonusNumber) {
        return ranking.winNumber == winCount &&
                (ranking != FIVE_PLUS_BONUS || hasBonusNumber);
    }

    public int getPrize() {
        return prize;
    }
}
