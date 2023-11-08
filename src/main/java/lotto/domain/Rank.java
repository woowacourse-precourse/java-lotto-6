package lotto.domain;

public enum Rank {
    FIFTH(3,0,"3개 일치 (5,000원) - %d개"),
    FOURTH(4,0,"4개 일치 (50,000원) - %d개"),
    THIRD(5,0,"5개 일치 (1,500,000원) - %d개"),
    SECOND(5,1,"5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6,0,"6개 일치 (2,000,000,000원) - %d개"),
    FAIL(0, 0, ""),
    ;

    private final int winningNumber;
    private final int bonusNumber;
    private final String drawResult;

    Rank(int winningNumber, int bonusNumber, String drawResult) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.drawResult = drawResult;
    }
    public int getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String getDrawResult() {
        return drawResult;
    }

    public static Rank getRank(int winningCount, int bonusCount){
        if (winningCount == Rank.FIRST.getWinningNumber()) {
            return FIRST;
        }

        if (winningCount == Rank.SECOND.getWinningNumber() && bonusCount == Rank.SECOND.getBonusNumber()) {
            return SECOND;
        }

        if (winningCount == Rank.THIRD.getWinningNumber()) {
            return THIRD;
        }

        if (winningCount == Rank.FOURTH.getWinningNumber()) {
            return FOURTH;
        }

        if (winningCount == Rank.FIFTH.getWinningNumber()) {
            return FIFTH;
        }

        return FAIL; // No match
    }
}
