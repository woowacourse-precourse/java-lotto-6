package lotto.lottocompany;

public enum Reward {
    FIRST("6개 일치", 6,
            2_000_000_000, "2,000,000,000원"),
    SECOND("5개 일치, 보너스 볼 일치", 5,
            30_000_000, "30,000,000원"),
    THIRD("5개 일치", 5,
            1_500_000, "1,500,000원"),
    FOURTH("4개 일치", 4,
            50_000, "50,000원"),
    FIFTH("3개 일치", 3,
            5_000, "5,000원"),
    NONE("불일치", -999, 0, "0원");

    private final String prizeInformation;
    private final int winCondition;
    private final int prizeMoney;
    private final String prizeMoneyMessage;

    Reward(String prizeInformation, int winCondition, int prizeMoney, String prizeMoneyMessage) {
        this.prizeInformation = prizeInformation;
        this.winCondition = winCondition;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyMessage = prizeMoneyMessage;
    }

    public int getWinCondition() {
        return winCondition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
