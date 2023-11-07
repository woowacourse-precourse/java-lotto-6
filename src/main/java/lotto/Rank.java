package lotto;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public String getBonus() {
        if (this == SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == 5 && !matchBonus) {
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}