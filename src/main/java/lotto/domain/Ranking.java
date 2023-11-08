package lotto.domain;

public enum Ranking {

    NONE(-1, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);


    private final int correctCount;
    private final boolean bonusCheck;
    private final int prize;

    Ranking(int correctCount, boolean bonusCheck, int prize) {
        this.correctCount = correctCount;
        this.bonusCheck = bonusCheck;
        this.prize = prize;
    }


}
