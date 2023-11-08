package lotto.domain.winningnumber;

import lotto.global.util.Converter;
import lotto.global.util.Validation;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> convertedWinningNumbers = Converter.convertStringToIntList(inputWinningNumbers);
        int convertedBonusNumber = Converter.convertStringToInt(inputBonusNumber);
        validate(convertedWinningNumbers, convertedBonusNumber);
        this.winningNumbers = convertedWinningNumbers;
        this.bonusNumber = convertedBonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        Validation validation = new Validation();
        validation.isSixNumbers(winningNumbers);
        validation.isNumbersInRangeOf1To45(winningNumbers);
        validation.hasDuplicateNumbers(winningNumbers);
        validation.isInRangeOf1To45(bonusNumber);
        validation.hasSameNumberInList(bonusNumber, winningNumbers);
    }
}
