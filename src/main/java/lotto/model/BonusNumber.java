package lotto.model;

public class BonusNumber {

    private Integer bonusNumber;

    private BonusNumber(String bonusNumber, WinningNumber winningNumber) {
        
    }

    public static BonusNumber create(String bonusNumber, WinningNumber winningNumber) {
        return new BonusNumber(bonusNumber, winningNumber);
    }
}
