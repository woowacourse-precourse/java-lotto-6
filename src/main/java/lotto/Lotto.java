package lotto;

import lotto.constants.LottoConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countMatchingNumbers(Lotto winningNumbers) {
        return (int) winningNumbers.numbers
                .stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isSizeDifferent(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또는" +  LottoConfig.LOTTO_NUMBERS_SIZE + "여야합니다.");
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
        }

        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위가 아닙니다.");
        }
    }

    private boolean isSizeDifferent(List<Integer> numbers) {
        return numbers.size() != LottoConfig.LOTTO_NUMBERS_SIZE;
    }

    private boolean hasDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return numbers.size() != uniqueNumbers.size();
    }

    private boolean isNotInRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoConfig.LOTTO_NUMBER_MIN || number > LottoConfig.LOTTO_NUMBER_MAX);
    }

}
