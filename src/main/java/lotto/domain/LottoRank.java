package lotto.domain;

public enum LottoRank {
    FIRST(6,2000000000, "6개 일치"),
    SECOND(530,000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5,1500000, "5개 일치"),
    FOURTH(4,50000, "4개 일치"),
    FIFTH(3,5000, "3개 일치");

    private int rank;
    private int money;
    private String winningMessage;

    LottoRank(int rank, int money, String winningMessage) {
        this.rank = rank;
        this.money = money;
        this.winningMessage = winningMessage;
    }

    public int getRank() {
        return rank;
    }

    public int getMoney() {
        return money;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
