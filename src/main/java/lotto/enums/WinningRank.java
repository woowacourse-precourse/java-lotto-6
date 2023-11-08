package lotto.enums;

public enum WinningRank {
    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchNumber;
    private final int returnAmount;

    WinningRank(int matchNumber, int returnAmount) {
        this.matchNumber = matchNumber;
        this.returnAmount = returnAmount;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public static WinningRank fromMatchNumber(int matchNumber) {
        WinningRank result = null;
        for (WinningRank rank : WinningRank.values()) {
            if (rank.getMatchNumber() == matchNumber) {
                result = rank;
                break;
            }
        }
        return result;
    }
}
