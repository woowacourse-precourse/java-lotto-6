package lotto.domain;

import java.util.List;

public class ResultNumber {
    private static ResultNumber resultNumber =null;
    private List<Integer> winningNumber;
    private int bonusNumber;

    private ResultNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static ResultNumber create(List<Integer> winningNumber, int bonusNumber) {
        if(resultNumber == null){
            resultNumber = new ResultNumber(winningNumber, bonusNumber);
        }
        return resultNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}