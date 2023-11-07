package lotto.domain.statistics;

public enum LottoRank {

    FIRST_PLACE(6,2000000000),
    SECOND_PLACE(5,30000000),
    THIRD_PLACE(5,1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000);

    private final int standard;
    private final int prize;

    LottoRank(int standard, int prize) {
        this.standard = standard;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getStandard() {
        return standard;
    }

}
