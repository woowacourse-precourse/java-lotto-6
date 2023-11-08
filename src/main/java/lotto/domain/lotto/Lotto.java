package lotto.domain.lotto;

import lotto.constants.lotto.LottoRule;
import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoNumbersSizeException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static Boolean isInRange(Integer number) {
        return number >= LottoRule.START_NUMBER && number <= LottoRule.END_NUMBER;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.NUMBER_MAX_SIZE) {
            throw new LottoNumbersSizeException();
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        long numbersCount = getCountFilterByLottoRange(numbers);
        if (numbersCount != LottoRule.NUMBER_MAX_SIZE) {
            throw new LottoNumberRangeException();
        }
    }

    private long getCountFilterByLottoRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(Lotto::isInRange)
                .count();
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        long numbersCount = getCountFilterByDuplicated(numbers);
        if (numbersCount < LottoRule.NUMBER_MAX_SIZE) {
            throw new LottoNumberDuplicateException();
        }
    }

    private long getCountFilterByDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
