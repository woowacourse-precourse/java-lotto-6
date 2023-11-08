package lotto.domain.result;

public enum Grade {
    FIRST("6개 일치", "2,000,000,000원"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000원"),
    THIRD("5개 일치", "1,500,000원"),
    FOURTH("4개 일치", "50,000원"),
    FIFTH("3개 일치", "5,000원"),
    NOTHING("1 또는 2개 일치", "0원");

    private String condition;
    private String prize;

    private Grade() {
    }

    private Grade(String condition, String prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public String getCondition() {
        return condition;
    }

    public String getPrize() {
        return prize;
    }
}
