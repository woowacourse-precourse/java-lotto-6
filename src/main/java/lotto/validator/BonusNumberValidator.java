package lotto.validator;

import java.util.List;
import lotto.constant.LottoNumber;
import lotto.constant.message.ErrorMessage;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static int validate(String bonusNumberInput, String winningNumbersInput) {
        checkIfNumeric(bonusNumberInput.trim());
        int bonusNumber = parseBonusNumberToInt(bonusNumberInput);
        checkRange(bonusNumber);
        checkIfBonusNumberInWinningNumbers(bonusNumber, winningNumbersInput);
        return bonusNumber;
    }

    private static int parseBonusNumberToInt(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.INVALID_RANGE.getMessage(
                    LottoNumber.MIN_INCLUSIVE.getNumber(), LottoNumber.MAX_INCLUSIVE.getNumber()));
        }
    }

    private static void checkIfNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private static void checkRange(int number) {
        if (LottoNumberValidator.isNumberOutOfRange(number)) {
            throw new IndexOutOfBoundsException(ErrorMessage.INVALID_RANGE.getMessage(
                    LottoNumber.MIN_INCLUSIVE.getNumber(), LottoNumber.MAX_INCLUSIVE.getNumber()));
        }
    }

    private static void checkIfBonusNumberInWinningNumbers(int bonusNumber, String winningNumbersInput) {
        List<Integer> winningNumbers = LottoNumberValidator.convertStringToList(winningNumbersInput);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
