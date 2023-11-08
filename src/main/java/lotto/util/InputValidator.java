package lotto.util;

import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_COUNT;
import static lotto.util.constant.ValidatorStatus.NON_DIGIT;
import static lotto.util.constant.ValidatorStatus.NOT_DIVIDABLE;

import java.util.Arrays;
import java.util.List;
import lotto.util.exception.ExceptionHandler;

public class InputValidator {

    private final ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
    private List<String> rawLottoNumbers;

    public void validateMoney(String input) {
        isInputDigit(input);
        isDivisibleBy1000(input);
    }
    public void validateRawLottoNumbers(String input) {
        isValidLottoNumberFormat(input);
        isInputOnlyDigit();

    }
    public void validateRawLottoBonusNumber(String input) {
        isInputDigit(input);
    }

    private void isInputDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            exceptionHandler.validatorStatusMap.get(NON_DIGIT).accept(NON_DIGIT);
        }
    }

    private void isDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            exceptionHandler.validatorStatusMap.get(NOT_DIVIDABLE).accept(NOT_DIVIDABLE);
        }
    }

    private void isInputOnlyDigit() {
        rawLottoNumbers.forEach(this::isInputDigit);
    }

    private void isValidLottoNumberFormat(String input) {
        rawLottoNumbers = Arrays.stream(input.split(",")).toList();
        if (rawLottoNumbers.isEmpty() || rawLottoNumbers.size() > 6) {
            exceptionHandler.validatorStatusMap.get(INVALID_WINNING_NUMBER_COUNT).accept(INVALID_WINNING_NUMBER_COUNT);
        }
    }

}
