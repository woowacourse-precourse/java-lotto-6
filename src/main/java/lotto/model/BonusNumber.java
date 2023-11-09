package lotto.model;

import java.util.List;
import lotto.view.message.Error;

public class BonusNumber {

    private Integer bonusNumber;

    private BonusNumber(String candidateBonusNumber, WinningNumber winningNumber) {
        Integer convertedBonusNumber = toInteger(candidateBonusNumber);
        checkOutOfRange(convertedBonusNumber);
        checkDuplicate(convertedBonusNumber, winningNumber);
        bonusNumber = convertedBonusNumber;
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

    private void checkOutOfRange(Integer convertedBonusNumber) {
        if (convertedBonusNumber < Lotto.MIN_NUMBER || convertedBonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkDuplicate(Integer convertedBonusNumber, WinningNumber winningNumber) {
        if (winningNumber.getWinningNumbers().contains(convertedBonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_DUPLICATE_WITH_WINNINGNUMBER.getMessage());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public boolean isBonusMatch(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
