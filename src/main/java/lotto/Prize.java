package lotto;

public enum Prize {
    PRIZE_1ST("6개 일치 (2,000,000,000원) - ", 2000000000),
    PRIZE_2ND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    PRIZE_3RD("5개 일치 (1,500,000원) - ", 1500000),
    PRIZE_4th("4개 일치 (50,000원) - ", 50000),
    PRIZE_5th("3개 일치 (5,000원) - ", 5000);

    private final String ui;
    private final int money;

    private Prize(String s, int i) {
        this.ui = s;
        this.money = i;
    }

    public String getUI(){
        return this.ui;
    }
    public int getMoney(){
        return this.money;
    }
}
