package lotto.Model;

import java.util.Arrays;

public enum Winning {
    FIFTH(3, 5000, 0),
    FOURTH(4, 50000, 0),
    THIRD(5, 1500000, 0),
    SECOND(5, 30000000, 1),
    FIRST(6, 2000000000, 0),
    No_Match(0, 0, 0);

    private final int matchNumber;
    private final int winningPrice;
    private final int checkBonusBall;

    Winning(int matchNumber, int winningPrice, int checkBonusBall) {
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


    public static Winning result(int matchNumber, int checkBonusBall){
        if (matchNumber == SECOND.matchNumber && checkBonusBall == SECOND.checkBonusBall){
            return SECOND;
        }

        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchNumber == matchNumber)
                .findAny()
                .orElse(No_Match);
    }

}
