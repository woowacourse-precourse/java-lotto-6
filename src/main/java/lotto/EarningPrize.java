package lotto;

public enum EarningPrize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private int Prize;

    EarningPrize(int prize) {
        this.Prize = prize;
    }

    public int getPrize() {
        return Prize;
    }
}
