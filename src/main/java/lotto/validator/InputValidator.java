package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.message.ErrorMessage;
import lotto.model.LottoCondition;

public class InputValidator {
    private static final int MIN_NUMBER = LottoCondition.MIN_NUMBER.getNumber();
    private static final int MAX_NUMBER = LottoCondition.MAX_NUMBER.getNumber();
    private static final int COUNT = LottoCondition.COUNT.getNumber();

    public void validatePrice(String input) {
        validateInteger(input);
        int price = Integer.parseInt(input);
        validatePositiveInteger(price);
        validateMultipleOfThousand(price);
    }

    public void validateWinningNumber(String winningNumberInput) {
        validateLength(winningNumberInput);
        validateDuplicate(winningNumberInput);
        validateInRange(winningNumberInput);
    }

    public void validateBonusNumber(String bonusNumberInput) {
        validateInteger(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateInRange(bonusNumber);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.NO_INTEGER.getErrorMessage());
        }
    }

    private void validatePositiveInteger(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.NO_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validateMultipleOfThousand(int number) {
        if(number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.UNIT_RESTRICTION.getErrorMessage());
        }
    }

    private void validateLength(String winningNumber) {
        long winningNumberLength = Arrays.stream(winningNumber.split(",")).count();
        if(winningNumberLength != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.NOT_LENGTH_SIX.getErrorMessage());
        }
    }

    private void validateDuplicate(String winningNumber) {
         List<Integer> numbers = Arrays.asList(winningNumber.split(","))
                                        .stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
         HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
         if(numbers.size() > uniqueNumbers.size()) {
             throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                        ErrorMessage.HAS_DUPLICATED_NUMBER.getErrorMessage());
         }
    }

    public void validateBonusNumberNotDuplicate(Set<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.HAS_DUPLICATED_WINNING_NUMBER_WITH_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateInRange(String winningNumber) {
        List<Integer> numbers = Arrays.asList(winningNumber.split(","))
                                        .stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        for(int number : numbers) {
            if(number > MAX_NUMBER || number < MIN_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                        ErrorMessage.OUT_OF_RANGE.getErrorMessage());
            }
        }
    }

    private void validateInRange(int bonusNumber) {
        if(bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getErrorMessage() +
                                                    ErrorMessage.OUT_OF_RANGE.getErrorMessage());
        }
    }
}
