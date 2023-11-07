package lotto.enums;

public enum WinningRank {
    FIRST(6),
    SECOND(7),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);

    private final int matchNumber;

    WinningRank(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
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
