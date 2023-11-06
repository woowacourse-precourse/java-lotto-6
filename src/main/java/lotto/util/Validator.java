package lotto.util;

import static lotto.util.constant.ValidatorStatus.INVALID_BONUS_NUMBER_INPUT;
import static lotto.util.constant.ValidatorStatus.INVALID_NUMBER_RANGE;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_COUNT;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.util.constant.ValidatorStatus.NON_DIGIT;
import static lotto.util.constant.ValidatorStatus.NOT_DIVIDABLE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.exception.ExceptionHandler;

public class Validator {

    private final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private List<String> rawInput;

    public void validateMoney(String input) {
        isInputDigit(input);
        isDivisibleBy1000(input);
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

    public void validateLottoNumbers(String input) {
        isValidLottoNumberFormat(input);
        isDuplicateLottoNumber();
        isValidLottoNumberRange();
    }

    private void isValidLottoNumberFormat(String input) {
        rawInput = Arrays.stream(input.split(",")).toList();
        if (rawInput.isEmpty() || rawInput.size() > 6) {
            exceptionHandler.validatorStatusMap.get(INVALID_WINNING_NUMBER_COUNT).accept(INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private void isDuplicateLottoNumber() {
        Set<String> formatCheck = new HashSet<>(rawInput);
        if (rawInput.size() != formatCheck.size()) {
            exceptionHandler.validatorStatusMap.get(INVALID_WINNING_NUMBER_FORMAT)
                    .accept(INVALID_WINNING_NUMBER_FORMAT);
        }
    }

    private void isValidLottoNumberRange() {
        rawInput.forEach(this::isValidNumberRange);
    }

    private void isValidNumberRange(String number) {
        int convertedNumber = Integer.parseInt(number);
        if (convertedNumber < 0 || 45 < convertedNumber) {
            exceptionHandler.validatorStatusMap.get(INVALID_NUMBER_RANGE)
                    .accept(INVALID_NUMBER_RANGE);
        }
    }

    public void validateLottoBonusNumber(String input) {
        isInputDigit(input);
        isValidNumberRange(input);
        isDuplicateBonusNumber(input);
    }

    private void isDuplicateBonusNumber(String input) {
        if (rawInput.contains(input)) {
            exceptionHandler.validatorStatusMap.get(INVALID_BONUS_NUMBER_INPUT)
                    .accept(INVALID_BONUS_NUMBER_INPUT);
        }
    }
}
