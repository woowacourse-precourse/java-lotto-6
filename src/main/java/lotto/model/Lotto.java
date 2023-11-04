package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::generateLottoNumber)
                .toList();
    }

    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
