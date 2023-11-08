package lotto.domain;

public enum LottoRank {
    FIRST(2000000000, "6개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "5개 일치"),
    FOURTH(50000, "4개 일치"),
    FIFTH(5000, "3개 일치"),
    NO_LUCK(0, "2개 이하");
    private int money;
    private String winningMessage;

    LottoRank(int money, String winningMessage) {
        this.money = money;
        this.winningMessage = winningMessage;
    }


    public int getMoney() {
        return money;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public static LottoRank of(int count, boolean bonusIsExists) {
        if (count == 6) {
            return FIRST;
        }
        if (count == 5) {
            return secondOrThird(bonusIsExists);
        }
        if (count == 4) {
            return FOURTH;
        }
        if (count == 3) {
            return FIFTH;
        }
        return NO_LUCK;
    }

    public static LottoRank secondOrThird(boolean bonusIsExists) {
        if (bonusIsExists) {
            return SECOND;
        }
        return THIRD;
    }
}
