package lotto.domain;

import java.util.List;

public class ResultNumber {
    private static ResultNumber resultNumber =null;
    private static WinningNumber winningNumber;
    private static BonusNumber bonusNumber;

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

    public static List<Integer> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public static int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}