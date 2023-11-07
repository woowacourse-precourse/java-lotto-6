package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumbers(final List<Integer> numbers) {
        isNotEmpty(numbers);
        isDistinct(numbers);
        isValidSize(numbers);
    }

    private void isNotEmpty(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 비어있을 수 없습니다.");
        }
    }

    private void isDistinct(final List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void isValidSize(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean contains(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }
}
