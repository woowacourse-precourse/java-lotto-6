package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String WRONG_LOTTO_NUMBER_MESSAGE = "6개의 로또 숫자를 입력하세요.";
    private static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "중복되지 않은 로또 숫자를 입력해주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Object obj) {
        return numbers.contains(obj);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    public int getMatchCount(Lotto lotto) {
        int matchCount = (int) numbers.stream()
                .filter(lotto::contains)
                .count();
        return matchCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> kindOfNumber = new HashSet<>(numbers);
        if (kindOfNumber.size() == numbers.size()) return;
        throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_MESSAGE);
    }
}
