package lotto.model;

public enum LottoPrize {
    FIRST_PRIZE(0,"6개 일치 (2,000,000,000원) - ","개",2000000000),
    SECOND_PRIZE(0,"5개 일치, 보너스 볼 일치 (30,000,000원) - ","개", 30000000),
    THIRD_PRIZE(0,"5개 일치 (1,500,000원) - ","개", 1500000),
    FOURTH_PRIZE(0,"4개 일치 (50,000원) - ","개", 50000),
    FIFTH_PRIZE(0,"3개 일치 (5,000원) - ","개", 5000),
    LOOSE(0,"","개", 0);


    private int winCount;
    private final String text;
    private final String unit;
    private  int prizeMoney;

    LottoPrize(int winCount, String text, String unit, int prizemoney) {
        this.winCount = winCount;
        this.text = text;
        this.unit = unit;
        this.prizeMoney = prizemoney;
    }
    public int getWinCount() {
        return winCount;
    }
    public String getText() {
        return text;
    }
    public String getUnit() {
        return unit;
    }
    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void addWinCount() {
        this.winCount ++;
    }
}
