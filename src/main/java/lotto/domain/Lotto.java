package lotto.domain;

import lotto.constant.LottoConfig;

import static lotto.constant.ErrorMessage.ERROR_LOTTO_DUPLICATE;
import static lotto.constant.ErrorMessage.ERROR_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countMatches(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(List<Integer> numbers){
        if (numbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE.toString());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE.toString());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}