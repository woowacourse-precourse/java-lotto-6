package lotto;

public enum LottoResult {
    THIRD(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(5, 1500000, "5개 일치 (1,500,000원)"),
    BONUS(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIXTH(6, 2000000000, "6개 일치 (2,000,000,000원)");


    private final int count;
    private final float money;
    private final String won;

    LottoResult(int count, float money, String won) {
        this.count = count;
        this.money = money;
        this.won = won;
    }

    public int getCount() {
        return count;
    }

    public float getMoney() {
        return money;
    }

    public String getWon() {
        return won;
    }
}
