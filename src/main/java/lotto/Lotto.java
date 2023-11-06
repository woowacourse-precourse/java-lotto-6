package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.LottoConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_OVERSIZED_MESSAGE);
        }
        if (new HashSet<>(numbers).size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Grade draw(Lotto winning, Integer bonus) {
        int count = (int) winning.numbers.stream()
                .filter(number -> contains(number))
                .count();
        boolean contains = contains(bonus);

        return Grade.draw(count, contains);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
