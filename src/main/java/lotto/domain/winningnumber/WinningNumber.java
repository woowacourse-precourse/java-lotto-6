package lotto.domain.winningnumber;

import lotto.global.common.ErrorMessage;
import lotto.global.util.Validation;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> convertedWinningNumbers = convertStringToIntAfterSplit(inputWinningNumbers);
        int convertedBonusNumber = convertStringToInt(inputBonusNumber);
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

    private List<Integer> convertStringToIntAfterSplit(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String s : inputNumbers.split(",")) {
                numbers.add(Integer.parseInt(s.trim()));
            }
            return numbers;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private int convertStringToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
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
