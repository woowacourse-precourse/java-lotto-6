package lotto.model;

import static lotto.constant.UIConstant.CLOSING_BRACKET;
import static lotto.constant.UIConstant.NEW_LINE;
import static lotto.constant.UIConstant.NUMBER_SEPARATOR;
import static lotto.constant.UIConstant.OPENING_BRACKET;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_MATCHED_NUMBER_COUNT.getMessage());
        }

        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);
        if (isOutOfRange)
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_NUMBER.getMessage());
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = this.getSortedNumbers();
        String result = sortedNumbers.stream().map(String::valueOf).collect(Collectors.joining("" + NUMBER_SEPARATOR + " "));
        return OPENING_BRACKET + result + CLOSING_BRACKET + NEW_LINE;
    }

    private List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
