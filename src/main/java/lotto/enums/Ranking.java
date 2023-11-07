package lotto.enums;

import lotto.domain.Lotto;

public enum Ranking {
    BLANK(0, 2, false, "낙첨"),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FORTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private static final int ZERO = 0;
    private final int prize;
    private final int corrects;
    private final boolean bonus;
    private final String result;

    public static Ranking findRanking(int corrects, boolean bonus) {
        validateCorrectsRange(corrects);
        validateCorrectsBonus(corrects, bonus);

        if (FIRST.corrects == corrects) {
            return FIRST;
        }
        if (SECOND.bonus == bonus
                && SECOND.corrects == corrects) {
            return SECOND;
        }
        if (THIRD.bonus == bonus
                && THIRD.corrects == corrects) {
            return THIRD;
        }
        if (FORTH.corrects == corrects) {
            return FORTH;
        }
        if (FIFTH.corrects == corrects) {
            return FIFTH;
        }
        return BLANK;
    }

    private static void validateCorrectsRange(int corrects) {
        if (corrects < ZERO || corrects > Lotto.getNumbersSize()) {
            throw new IllegalStateException();
        }
    }

    private static void validateCorrectsBonus(int corrects, boolean bonus) {
        if (corrects == Lotto.getNumbersSize() && bonus) {
            throw new IllegalStateException();
        }
    }

    Ranking(int prize, int corrects, boolean bonus, String result) {
        this.prize = prize;
        this.corrects = corrects;
        this.bonus = bonus;
        this.result = result;
    }

    public int getPrize() {
        return prize;
    }

    public String getResult() {
        return result;
    }
}
