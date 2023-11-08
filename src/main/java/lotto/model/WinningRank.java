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

    public static WinningRank valueOf(int count, boolean bonus) {
        if (count == 3)
            return WinningRank.MATCH3;
        if (count == 4)
            return WinningRank.MATCH4;
        if (count == 5) {
            if (bonus)
                return WinningRank.MATCH5BONUS;
            return WinningRank.MATCH5;
        }
        if (count == 6)
            return WinningRank.MATCH6;
        return WinningRank.LOSE;
    }
}
