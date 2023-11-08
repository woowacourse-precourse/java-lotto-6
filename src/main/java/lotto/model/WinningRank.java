package lotto.model;

public enum WinningRank {
    LOSE,
    MATCH3(3, false, "5,000", 5000),
    MATCH4(4, false, "50,000", 50000),
    MATCH5(5, false, "1,500,000", 1500000),
    MATCH5BONUS(5, true, "30,000,000", 30000000),
    MATCH6(6, false, "2,000,000,000", 2000000000);

    public int count;

    public boolean bonus;

    public String prizeCommaSeperated;

    public int prize;

    WinningRank() {}

    WinningRank(int count, boolean bonus, String prizeCommaSeperated, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prizeCommaSeperated = prizeCommaSeperated;
        this.prize = prize;
    }

    public static WinningRank of(int count, boolean bonus) {
        if (count == 3) {
            System.out.println(WinningRank.MATCH3.prizeCommaSeperated);
            return WinningRank.MATCH3;
        }
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
