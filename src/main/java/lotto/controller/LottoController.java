package lotto.controller;

import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static lotto.constant.LottoInfo.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {

    public void inputNumbers(String input) {
        validateInputSize(input);
        validateDuplicateNumber(validateIsNumeric(input));
    }

    private void validateInputSize(String input) {
        if (Arrays.stream(input.split(" ")).count() != LOTTO_SIZE.getInfo()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private List<Integer> validateIsNumeric(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR.getMessage());
            }
            inputNumbers.add((Character.getNumericValue(ch)));
        }

        return inputNumbers;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

}
