package lotto.domain;

public enum LottoResult {
    MISS(0, false, 0, ""),
    FIFTH(0, false, 0, ""),
    FOURTH(0, false, 0, ""),
    THIRD(0, false, 0, ""),
    SECOND(0, false, 0, ""),
    FIRST(0, false, 0, "");


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

    public static LottoResult valueOf(int count, boolean bonus){

        return MISS;
    }

    public String getMessage(int winningCount) {
        return message.formatted(winningCount);
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
