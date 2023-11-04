package lotto.domain;

import java.util.List;

public class ResultNumber {
    private static ResultNumber resultNumber =null;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    private ResultNumber(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static ResultNumber create(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if(resultNumber == null){
            resultNumber = new ResultNumber(winningNumber, bonusNumber);
        }
        return resultNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}