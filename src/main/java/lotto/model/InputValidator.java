package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.model.exceptions.NotCorrectInputException;
import lotto.model.exceptions.NotIntegerException;
import lotto.model.exceptions.OutOfRangeNumberException;

public class InputValidator {
    // 당첨 번호 검증
    public List<Integer> validateInput(List<String> input) {
        List<Integer> inputNumbers = validateInteger(input);
        validateInRangeNumber(inputNumbers);
        return inputNumbers;
    }

    // 정수 검증
    private List<Integer> validateInteger(List<String> numbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            try {
                integerNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NotCorrectInputException();
            }
        });
        return integerNumbers;
    }

    // 범위 밖 숫자 검증
    private void validateInRangeNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_NUMBER.getValue() || number < MIN_NUMBER.getValue())
                .forEach(number -> {
                    throw new OutOfRangeNumberException();
                });
    }

    // 보너스 번호 검증
    public int validateInput(String input) {
        int inputNumber = validateInteger(input);
        validateInRangeNumber(inputNumber);
        return inputNumber;
    }

    // 정수 검증
    private int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }

    // 범위 밖 숫자 검증
    private void validateInRangeNumber(int inputNumber) {
        if (inputNumber > MAX_NUMBER.getValue() || inputNumber < MIN_NUMBER.getValue()) {
            throw new OutOfRangeNumberException();
        }
    }
}