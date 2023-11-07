package lotto.model;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int prizeMoney;

    LottoResult(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = winningMoney;
    }

    public static LottoResult calculate(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == 5) {
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        if (countOfMatch == 6) {
            return FIRST;
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
