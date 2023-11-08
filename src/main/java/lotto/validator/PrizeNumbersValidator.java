package lotto.validator;

import static lotto.constants.Constants.LOTTO_COUNT;
import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Message.LOTTO_COUNT_ERROR;
import static lotto.constants.Message.LOTTO_NUMBER_ERROR;
import static lotto.constants.Message.LOTTO_DUPLICATED_ERROR;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeNumbersValidator {
    public List<Integer> numbers;
    private List<String> splitedNumbers;

    public void validate(String numbers) {
        count(numbers);
        isNumber();
        isCorrectNumber();
        isDuplicated();
        Collections.sort(this.numbers);
    }

    private void count(String numbers) {
        try {
            splitedNumbers = Arrays.asList(numbers.split(","));
            if (splitedNumbers.size() != LOTTO_COUNT) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR.getErrorMessage());
        }
    }

    private void isNumber() {
        try {
            this.numbers = splitedNumbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR.getErrorMessage());
        }
    }

    private void isCorrectNumber() {
        for (int number : this.numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_ERROR.getErrorMessage());
            }
        }
    }

    private void isDuplicated() {
        if (this.numbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_ERROR.getErrorMessage());
        }
    }
}
