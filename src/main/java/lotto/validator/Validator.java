package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.SystemOption.*;
import static lotto.constants.SystemOption.PAYMENT_UNIT_VALUE;
import static lotto.message.ErrorMessage.*;

public class Validator {
    public int parseAndValidatePayment(String userInput) {
        int payment = parseAndValidateInteger(userInput);
        validatePositive(payment);
        validateUnit(payment);
        return payment;
    }

    private int parseAndValidateInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private void validatePositive(int payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE.toString());
        }
    }

    private void validateUnit(int payment) {
        if (payment % PAYMENT_UNIT_VALUE.getValue() != 0) {
            throw new IllegalArgumentException(WRONG_UNIT_ERROR_MESSAGE.toString());
        }
    }

    public List<Integer> parseAndValidateTargetNumbers(String userInput) {
        List<Integer> targetNumbers = parseAndValidateNumbers(userInput);
        validateSize(targetNumbers);
        validateRangeOfNumbers(targetNumbers);
        validateUnique(targetNumbers);
        return targetNumbers;
    }

    private List<Integer> parseAndValidateNumbers(String userInput) {
        try {
            String[] numbers = userInput.split(",");

            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private void validateRangeOfNumbers(List<Integer> targetNumbers) {
        for (Integer targetNumber : targetNumbers) {
            validateRangeOfNumber(targetNumber);
        }
    }

    private void validateRangeOfNumber(Integer targetNumber) {
        if (targetNumber < LOWER_BOUND_LOTTO_VALUE.getValue()
                || targetNumber > UPPER_BOUND_LOTTO_VALUE.getValue()) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE.toString());
        }
    }

    private void validateUnique(List<Integer> targetNumbers) {
        int distinctSize = getDistinctSize(targetNumbers);

        if (distinctSize != targetNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    private int getDistinctSize(List<Integer> targetNumbers) {
        return targetNumbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    private void validateSize(List<Integer> targetNumbers) {
        if (targetNumbers.size() != TARGET_NUMBERS_SIZE_VALUE.getValue()) {
            throw new IllegalArgumentException(WRONG_NUMBERS_SIZE_ERROR_MESSAGE.toString());
        }
    }

    public int parseAndValidateBonusNumber(String userInput) {
        int bonusNumber = parseAndValidateInteger(userInput);
        validateRangeOfNumber(bonusNumber);
        return bonusNumber;
    }

    public void checkDuplicateBonusNumber(List<Integer> targetNumbers, int bonusNumber) {
        if (targetNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE.toString());
        }
    }
}
