package lotto.model;

public enum WinningRank {
    MATCH6(6),
    MATCH5BONUS(5, true),
    MATCH5(5, false),
    MATCH4(4),
    MATCH3(3),
    LOSE(0);

    private int count;

    private boolean bonus;

    WinningRank(int count) {
        this.count = count;
    }

    WinningRank(int count, boolean bonus) {
        this.count = count;
    }
}
