package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

/**
 * 로또 게임에서 사용되는 로또 번호들의 집합을 나타내는 클래스.
 */
public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoValidationException(LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new LottoValidationException(LottoError.DUPLICATE_WINNING_NUMBER.toString());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new LottoValidationException(LottoError.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    public int countMatches(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
