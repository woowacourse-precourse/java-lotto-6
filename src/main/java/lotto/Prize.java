package lotto;

public enum Prize {
    PRIZE_5th("3개 일치 (5,000원) - ", 5000,6),
    PRIZE_4th("4개 일치 (50,000원) - ", 50000,8),
    PRIZE_3RD("5개 일치 (1,500,000원) - ", 1500000,10),
    PRIZE_2ND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000,11),
    PRIZE_1ST("6개 일치 (2,000,000,000원) - ", 2000000000, 12);

    private final String ui;
    private final int money;
    private final int same;

    private Prize(String s, int i, int j) {
        this.ui = s;
        this.money = i;
        this.same=j;
    }

    public String getUI() {
        return this.ui;
    }

    public int getMoney() {
        return this.money;
    }
    public int getSame(){
        return this.same;
    }
}
