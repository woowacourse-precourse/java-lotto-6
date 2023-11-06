package lotto.enums;

public enum Ranking {
    BLANK(0, 2, false, "낙첨"),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FORTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int corrects;
    private final boolean bonus;
    private final String result;

    Ranking(int prize, int corrects, boolean bonus, String result) {
        this.prize = prize;
        this.corrects = corrects;
        this.bonus = bonus;
        this.result = result;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrects() {
        return corrects;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getResult() {
        return result;
    }
}
