package lotto;

public enum LotteryMatchNumber{
    THREE(3,"3개 일치 (5,000원)", 5000,0),
    FOUR(4, "4개 일치 (50,000원)", 50000,0),
    FIVE(5, "5개 일치 (1,500,000원)", 1500000,0),
    FIVEBONUS(6, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000,1),
    SIX(6, "6개 일치 (2,000,000,000원)", 2000000000,0)
    ;

    private final int count;
    private final String label;
    private final int profits;
    private final int bonus;

    LotteryMatchNumber(int count, String label, int profits, int bonus) {
        this.count = count;
        this.label = label;
        this.profits = profits;
        this.bonus = bonus;
    }

    public int getProfits() {
        return profits;
    }

    public String getLabel() {
        return this.label;
    }
}
