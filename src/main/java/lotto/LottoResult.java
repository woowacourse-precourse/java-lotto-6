package lotto;

public enum LottoResult {
    THIRD("3", 5000, "(5,000원)"),
    FOURTH("4", 50000, "(50,000원)"),
    FIFTH("5", 1500000, "(1,500,000원)"),
    SIXTH("6", 2000000000, "(2,000,000,000원)"),
    BONUS("7", 30000000, "(30,000,000원)");

    private final String count;
    private final int money;
    private final String won;

    LottoResult(String count, int money, String won) {
        this.count = count;
        this.money = money;
        this.won = won;
    }

    public String getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public String getWon() {
        return won;
    }
}
