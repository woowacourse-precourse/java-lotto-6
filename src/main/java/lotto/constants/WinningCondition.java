package lotto.constants;

public enum WinningCondition {

    FIRST_PLACE(6, 0, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(5, 0, 1500000, "5개 일치 (1,500,000원)"),
    FORTH_PLACE(4, 0, 50000, "4개 일치 (50,000원)"),
    FIFTH_PLACE(3, 0, 5000, "3개 일치 (5,000원)");


    private final int sameWithWinningNumber;
    private final int sameWithBonusNumber;
    private final int prize;
    private final String message;

    WinningCondition(int sameWithWinningNumber, int sameWithBonusNumber, int prize, String message) {
        this.sameWithWinningNumber = sameWithWinningNumber;
        this.sameWithBonusNumber = sameWithBonusNumber;
        this.prize = prize;
        this.message = message;
    }

    public int getSameWithWinningNumberNumber() {
        return sameWithWinningNumber;
    }

    public int getSameWithBonusNumber() {
        return sameWithBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
