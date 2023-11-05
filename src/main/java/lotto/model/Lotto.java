package lotto.model;

import static lotto.util.message.Error.MUST_LOTTO_NO_DUP;
import static lotto.util.message.Error.MUST_LOTTO_RANGE;
import static lotto.util.message.Error.MUST_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.RandomNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> generator(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(new Lotto(RandomNumber.generate()));
        }
        return result;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MUST_LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(MUST_LOTTO_NO_DUP);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !(0 <= number && number <= 45))) {
            throw new IllegalArgumentException(MUST_LOTTO_RANGE);
        }
    }


}
