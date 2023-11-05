package lotto.model;

import lotto.view.message.Error;

public class BonusNumber {

    private Integer bonusNumber;

    private BonusNumber(String candidateBonusNumber, WinningNumber winningNumber) {
        Integer convertedBonusNumber = toInteger(candidateBonusNumber);
        
    }

    public static BonusNumber create(String candidateBonusNumber, WinningNumber winningNumber) {
        return new BonusNumber(candidateBonusNumber, winningNumber);
    }

    private Integer toInteger(String candidateBonusNumber) {
        try {
            return Integer.parseInt(candidateBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_NOT_INTEGER.getMessage());
        }
    }
}
