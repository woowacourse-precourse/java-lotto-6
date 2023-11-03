package lotto.model;

import static lotto.constant.UIConstant.*;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        String result = this.numbers.stream().map(String::valueOf).collect(Collectors.joining("" + NUMBER_SEPARATOR + BLANK));
        return OPENING_BRACKET + result + CLOSING_BRACKET + NEW_LINE;
    }
}
