package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
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

    public void validateWinningNumber(String winningNumberInput, String bonusNumberInput) {
        validateLength(winningNumberInput);
        validateDuplicate(winningNumberInput);
        validateInRange(winningNumberInput);

        validateInteger(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateInRange(bonusNumber);

        validateBonusNumberNotDuplicate(winningNumberInput, bonusNumber);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("허용하지 않는 숫자입니다");
        }
    }

    private void validatePositiveInteger(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("허용하지 않는 숫자입니다.");
        }
    }

    private void validateMultipleOfThousand(int number) {
        if(number % 1000 != 0) {
            throw new IllegalArgumentException("허용하지 않는 숫자입니다.");
        }
    }

    private void validateLength(String winningNumber) {
        long winningNumberLength = Arrays.stream(winningNumber.split(",")).count();
        if(winningNumberLength != COUNT) {
            throw new IllegalArgumentException("6개의 숫자가 아닙니다");
        }
    }

    private void validateDuplicate(String winningNumber) {
         List<Integer> numbers = Arrays.asList(winningNumber.split(","))
                                        .stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
         HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
         if(numbers.size() > uniqueNumbers.size()) {
             throw new IllegalArgumentException("중복 숫자가 존재합니다.");
         }
    }

    private void validateBonusNumberNotDuplicate(String winningNumber, int bonusNumber) {
        List<Integer> numbers = Arrays.asList(winningNumber.split(","))
                                        .stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복입니다.");
        }
    }

    private void validateInRange(String winningNumber) {
        List<Integer> numbers = Arrays.asList(winningNumber.split(","))
                                        .stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        for(int number : numbers) {
            if(number > MAX_NUMBER || number < MIN_NUMBER) {
                throw new IllegalArgumentException("번호가 범위를 벗어났습니다.");
            }
        }
    }

    private void validateInRange(int bonusNumber) {
        if(bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("번호가 범위를 벗어났습니다.");
        }
    }

}
