package lotto;

import java.util.Arrays;

public enum PrizeStandard {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private int winningCount;
    private int winningPrize;

    PrizeStandard(int winningCount, int winningPrize){
        this.winningCount = winningCount;
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize(){
        return winningPrize;
    }

    public boolean checkWinningCount(int toCheckCount){
        return this.winningCount == toCheckCount;
    }

    public static PrizeStandard findPrize(int inputWinning) {
        return Arrays.stream(PrizeStandard.values())
                .filter(operator -> operator.checkWinningCount(inputWinning))
                .findAny()
                .orElse(PrizeStandard.NOTHING);
    }
}
