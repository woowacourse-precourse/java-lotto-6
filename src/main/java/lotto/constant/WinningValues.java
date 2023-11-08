package lotto.constant;

public enum WinningValues {
    OUTPUT_LOTTO_NOTHING(0, 0, 0, "NOTHING"),
    OUTPUT_LOTTO_5TH_PLACE(3, 0, 5000, "3개 일치 (5,000원) - %d개"),
    OUTPUT_LOTTO_4TH_PLACE(4, 0, 50000, "4개 일치 (50,000원) - %d개"),
    OUTPUT_LOTTO_3RD_PLACE(5, 0, 1500000, "5개 일치 (1,500,000원) - %d개"),
    OUTPUT_LOTTO_2ND_PLACE(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_LOTTO_1ST_PLACE(6, 0, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int winningCount;
    private final int BonusNumberCount;
    private final int winningAmount;
    private final String printMessage;

    WinningValues(int winningCount, int BonusNumberCount, int winningAmount, String printMessage) {
        this.winningCount = winningCount;
        this.BonusNumberCount = BonusNumberCount;
        this.winningAmount = winningAmount;
        this.printMessage = printMessage;
    }

    public final int getWinningCount() {
        return winningCount;
    }

    public final int getBonusNumberCount() {
        return BonusNumberCount;
    }

    public final int getWinningAmount() {
        return winningAmount;
    }

    public final String getMessage() {
        return printMessage;
    }
}
