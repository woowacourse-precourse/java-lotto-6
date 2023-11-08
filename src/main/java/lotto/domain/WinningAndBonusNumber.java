package lotto.domain;

import java.util.List;

public class WinningAndBonusNumber {
    private static WinningAndBonusNumber winningAndBonusNumber =null;
    private static WinningNumber winningNumber;
    private static BonusNumber bonusNumber;

    private WinningAndBonusNumber(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningAndBonusNumber create(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if(winningAndBonusNumber == null){
            winningAndBonusNumber = new WinningAndBonusNumber(winningNumber, bonusNumber);
        }
        return winningAndBonusNumber;
    }

    public static List<Integer> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public static int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}