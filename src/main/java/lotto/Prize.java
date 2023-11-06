package lotto;

public enum Prize {
    THREE(3, 5000, "3개 일치 (5,000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원)"),
    BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원)");

    static final int LOTTO_COUNT = 6;
    private final int count;
    private final int amount;

    private final String information;

    Prize(int count, int amount, String information) {
        this.count = count;
        this.amount = amount;
        this.information = information;
    }

    public static int winningAmount(int matchWinningNumber, int matchBonusNumber) {
        if (matchWinningNumber == Prize.BONUS.count) {
            bonusNumber(matchBonusNumber);
        }
        for (Prize prize : Prize.values()) {
            if (prize.count == matchWinningNumber) {
                return prize.amount;
            }
        }
        return 0;
    }

    public static void bonusNumber(int matchBonusNumber) {

    }
}

