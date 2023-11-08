package lotto.Model;

import java.util.Arrays;

public enum Winning {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false),
    No_Match(0, 0, false);

    private final int matchNumber;
    private final int winningPrice;
    private final boolean checkBonusBall;

    Winning(int matchNumber, int winningPrice, boolean checkBonusBall) {
        this.matchNumber = matchNumber;
        this.winningPrice = winningPrice;
        this.checkBonusBall = checkBonusBall;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

    public int getWinningPrice(){
        return winningPrice;
    }


    public static Winning result(int matchNumber, boolean checkBonusBall){
        if (matchNumber == SECOND.matchNumber && checkBonusBall == SECOND.checkBonusBall){
            return SECOND;
        }

        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchNumber == matchNumber)
                .findAny()
                .orElse(No_Match);
    }

}
