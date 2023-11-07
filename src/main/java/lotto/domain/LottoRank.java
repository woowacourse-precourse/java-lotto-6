package lotto.domain;

public enum LottoRank {
    LOSE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int match;
    private final int prize;
    private final boolean bonus;

    LottoRank(int match, int prize, boolean bonus) {
        this.match = match;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static LottoRank whichRank(int match, boolean bonus){

        if (match == FIFTH.match) {
            return FIFTH;
        }
        if (match == FOURTH.match) {
            return FOURTH;
        }
        if ((match == THIRD.match) && (bonus == THIRD.bonus)) {
            return THIRD;
        }
        if ((match == SECOND.match) && (bonus == SECOND.bonus)) {
            return SECOND;
        }
        if (match == FIRST.match) {
            return FIRST;
        }
        return LOSE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }
}
