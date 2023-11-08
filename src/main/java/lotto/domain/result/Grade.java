package lotto.domain.result;

public enum Grade {
    FIRST("6개 일치", 2000000000, "2,000,000,000원"),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, "30,000,000원"),
    THIRD("5개 일치", 1500000, "1,500,000원"),
    FOURTH("4개 일치", 50000, "50,000원"),
    FIFTH("3개 일치", 5000, "5,000원"),
    NOTHING("1 또는 2개 일치", 0, "0원");

    private String condition;
    private int prize;
    private String prizeWon;

    private Grade() {
    }

    private Grade(String condition, int prize, String prizeWon) {
        this.condition = condition;
        this.prize = prize;
        this.prizeWon = prizeWon;
    }

    public String getCondition() {
        return condition;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeWon() {
        return prizeWon;
    }
}
