package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueElements(numbers, uniqueNumberSet(numbers));

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    private void validateUniqueElements(List<Integer> numbers, HashSet<Integer> uniqueNumberSet) {
        if (numbers.size() != uniqueNumberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 중복을 허용하지 않습니다.");
        }
    }

    private HashSet<Integer> uniqueNumberSet(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }
}
