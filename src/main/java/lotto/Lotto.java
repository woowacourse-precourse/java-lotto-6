package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static lotto.ErrorMessage.*;
import static lotto.LottoConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        numbers.forEach(Lotto::validateRange);
    }

    // TODO: 추가 기능 구현

    public static void validateRange(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_MESSAGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_OVERSIZED_MESSAGE);
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Optional<Grade> draw(Lotto winning, Integer bonus) {
        int count = (int) winning.numbers.stream()
                .filter(number -> contains(number))
                .count();
        boolean contains = contains(bonus);
        return Grade.get(count, contains);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
