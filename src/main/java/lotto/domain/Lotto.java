package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER_COUNT = "[ERROR] 로또 숫자 개수에 맞도록 다시 입력해 주세요.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 숫자 범위에 맞도록 다시 입력해 주세요.";
    private static final String INVALID_DUPLICATION = "[ERROR] 로또 숫자는 중복될 수 없습니다. 다시 입력해 주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION);
        }

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }

        if (numbers.stream().anyMatch(
                number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
        ) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public String getInformation() {
        return numbers.toString();
    }
}
