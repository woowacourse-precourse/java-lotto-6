package lotto.domain;

public enum Score {
    NULL(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int money;
    private final int sameNumber;

    private static final int YES = 1;
    private static final int NO = 0;

    Score(final int money, final int sameNumber) {
        this.money = money;
        this.sameNumber = sameNumber;
    }

    public static Score getScore(int sameNumberCount, int bonusContain) {
        if(sameNumberCount < FIFTH.getSameNumber()) {
            return Score.NULL;
        }
        else if(sameNumberCount == FIFTH.getSameNumber()) {
            return Score.FIFTH;
        }
        else if(sameNumberCount == FOURTH.getSameNumber()) {
            return Score.FOURTH;
        }
        else if(sameNumberCount == THIRD.getSameNumber() && bonusContain == NO) {
            return Score.THIRD;
        }
        else if(sameNumberCount == SECOND.getSameNumber() && bonusContain == YES) {
            return Score.SECOND;
        }
        else if(sameNumberCount == FIRST.getSameNumber()) {
            return Score.FIRST;
        }
        return Score.NULL;
    }

    public int getMoney() {
        return money;
    }

    public int getSameNumber() {
        return sameNumber;
    }
}

