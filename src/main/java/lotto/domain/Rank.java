package lotto.domain;

public enum Rank {
    NONE(0, 0, false, "불일치"),
    FIFTH(3, 5000, false,"3개 일치 "),
    FOURTH(4, 50000, false,"4개 일치 "),
    THIRD(5, 1500000, false,"5개 일치 "),
    SECOND(5, 30000000, true,"5개 일치, 보너스 볼 일치 "),
    FIRST(6, 2000000000, false,"6개 일치 ");

    private int count;
    private int profit;
    private boolean checkBonusNumber;
    private String message;

    Rank(int count, int profit, boolean checkBonusNumber, String message) {
        this.count = count;
        this.profit = profit;
        this.checkBonusNumber = checkBonusNumber;
        this.message = message;
    }

    public int getProfit() {
        return profit;
    }

    public String getMessage() {
        return message;
    }
}
