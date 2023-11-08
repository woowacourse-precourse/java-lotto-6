package lotto.constants;


public enum WinningResult {

    NO_MATCHED(0, "", 0),
    FIFTH_PRIZE(3, "3개 일치 (5,000원)", 5000),
    FOURTH_PRIZE(4, "4개 일치 (50,000원)", 50000),
    THIRD_PRIZE(5, "5개 일치 (1,500,000원)", 1500000),
    SECOND_PRIZE(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST_PRIZE(6, "6개 일치 (2,000,000,000원)", 2000000000);
    private int matchCount;
    private String message;
    private int prize;

    WinningResult(int matchCount, String message, int prize) {
        this.matchCount = matchCount;
        this.message = message;
        this.prize = prize;
    }

    public static WinningResult setResult(int matchCount, boolean bonusNumberCheck) {
        if (SECOND_PRIZE.checkMatchCount(matchCount) && bonusNumberCheck) {
            return SECOND_PRIZE;
        }
        for (WinningResult winningResult : WinningResult.values()) {
            if (winningResult.checkMatchCount(matchCount) && winningResult != SECOND_PRIZE) {
                return winningResult;
            }
        }
        return NO_MATCHED;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    private boolean checkMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

}