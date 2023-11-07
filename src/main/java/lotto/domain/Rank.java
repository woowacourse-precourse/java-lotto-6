package lotto.domain;

public enum Rank {
    FIFTH(3,0,5000),
    FOURTH(4,0,50000),
    THIRD(5,0,1500000),
    SECOND(5,1,30000000),
    FIRST(6,0,2000000000),
    FAIL(0, 0, 0),
    ;

    private final int winningNumber;
    private final int bonusNumber;
    private final int winningMoney;

    Rank(int winningNumber, int bonusNumber, int winningMoney) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = winningMoney;
    }
    public int getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(int winningCount, int bonusCount){
        if (winningCount == Rank.THIRD.getWinningNumber()) {
            return THIRD;
        }

        if (winningCount == Rank.FOURTH.getWinningNumber()){
            return FOURTH;
        }

        if (winningCount == Rank.THIRD.getWinningNumber() && bonusCount == Rank.THIRD.getBonusNumber()) {
            return THIRD;
        }

        if (winningCount == Rank.THIRD.getWinningNumber() && bonusCount == Rank.SECOND.getBonusNumber()) {
            return SECOND;
        }

        if (winningCount == Rank.FIRST.getWinningNumber()){
            return FIRST;
        }
        return FAIL;
    }
}
