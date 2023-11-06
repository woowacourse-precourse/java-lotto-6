package lotto.domain;

public enum LottoResult {
    MISS(0, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final boolean bonus;
    private final int winningAmount;
    private final String message;

    LottoResult(int count, boolean bonus, int winningAmount, String message) {
        this.count = count;
        this.bonus = bonus;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static LottoResult valueOf(int count, boolean bonus) {
        for (LottoResult result : values()) {
            if (result.count == count && result.bonus == bonus) {
                return result;
            }
        }

        return MISS;
    }

    public String getMessage(int winningCount) {
        return message.formatted(winningCount);
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
