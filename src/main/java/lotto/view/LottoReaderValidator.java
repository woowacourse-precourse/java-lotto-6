package lotto.view;

import java.util.List;

public class LottoReaderValidator {

    private static final String WINNING_NUMBERS = "^([1-9]{1},{1}|[1-3]{1}[0-9]{1},{1}|4{1}[0-5]{1},{1}){5}"
            + "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$";
    private static final String BONUS_NUMBER = "^[1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1}$";
    private static final String PAYMENT = "^[1-9]{1}[0-9]*000$";

    private LottoReaderValidator() {
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (!(winningNumbers.matches(WINNING_NUMBERS))) {
            throw new IllegalArgumentException(LottoInputErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateMoney(String inputMoney) {
        if (!(inputMoney.matches(PAYMENT))) {
            throw new IllegalArgumentException(LottoInputErrorMessage.INVALID_PAYMENT.getMessage());
        }
    }

    public static void validateBonusNumber(String inputBonusNumber) {
        if (!(inputBonusNumber.matches(BONUS_NUMBER))) {
            throw new IllegalArgumentException(LottoInputErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateDuplicationWithWinningNumbersAndBonusNumber(
            List<Integer> winningNumbers, int bonusNumber
    ) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoInputErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_NUMBERS.getMessage());
        }
    }
}
