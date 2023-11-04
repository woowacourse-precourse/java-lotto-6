package lotto.model;

import java.util.List;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;
    private LottoResult result;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        result = null;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
