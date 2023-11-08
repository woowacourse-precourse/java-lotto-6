package lotto.domain;

import java.util.List;

public class Lotto {
    public static final String LOTTO_PRIFIX = "[";
    public static final String LOTTO_SUFFIX = "]";
    public static final String NUMBER_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoMessage() {
        return LOTTO_PRIFIX + String.join(NUMBER_DELIMITER, convertToString(numbers)) + LOTTO_SUFFIX;
    }

    private List<String> convertToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
