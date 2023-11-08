package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.ErrorMessage;

public class InputLottoNumber {

    private final List<Integer> inputNumber;

    public InputLottoNumber(String inputNumber) {
        validate(inputNumber);
        this.inputNumber = parseInputNumberToList(inputNumber);
    }

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    private void validate(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }

        String[] numbersStr = inputNumber.split(",");
        if (numbersStr.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }

        Set<Integer> numbersSet = new HashSet<>();
        for (String numberStr : numbersStr) {
            int number;
            try {
                number = Integer.parseInt(numberStr.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            }

            // 1부터 45 사이의 숫자인지 확인합니다.
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }

            if (!numbersSet.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    private List<Integer> parseInputNumberToList(String inputNumber) {
        return Arrays.stream(inputNumber.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
