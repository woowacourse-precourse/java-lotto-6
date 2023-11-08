package lotto.config;

public enum LottoResultInform {
    THIRD(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(5, 1500000, "5개 일치 (1,500,000원)"),
    BONUS(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIXTH(6, 2000000000, "6개 일치 (2,000,000,000원)");


    private final int count;
    private final int money;
    private final String won;

    LottoResultInform(int count, int money, String won) {
        this.count = count;
        this.money = money;
        this.won = won;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public String getWon() {
        return won;
    }
}
