package lotto.model;

public enum Rank {

    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000),// 2등
    THIRD(5, 1_500_000),// 3등
    FOURTH(4, 50_000),// 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private int countOfMatch; // 일치 수
    private int gettingMoney; // 획득하는 돈

    Rank(int countOfMatch, int gettingMoney) {
        this.countOfMatch = countOfMatch;
        this.gettingMoney = gettingMoney;

    }

    public static Rank valueOf(int countOfMatch, boolean isMatchedBonus) {
        if (countOfMatch == 6) {
            return FIRST; // 1등
        }
        if (countOfMatch == 5 && isMatchedBonus) {
            return SECOND; // 2등
        }
        if (countOfMatch == 5) {
            return THIRD; // 3등
        }
        if (countOfMatch == 4) {
            return FOURTH; // 4등
        }
        if (countOfMatch == 3) {
            return FIFTH; // 5등
        }
        return MISS;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getGettingMoney() {
        return gettingMoney;
    }

}
