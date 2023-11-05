package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {

    private static final int NUM_OF_LOTTO_NUMBER = 6;
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> toValue() {
        return List.copyOf(numbers);
    }

    public int matchNum(final Lotto lotto) {
        final List<Integer> values = new ArrayList<>(this.numbers);
        values.retainAll(lotto.numbers);
        return values.size();
    }

    public boolean contains(final Integer numbner) {
        return numbers.contains(numbner);
    }
}
