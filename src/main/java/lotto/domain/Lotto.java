package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;
import lotto.config.LottoConfig;
import lotto.exception.InvalidLottoNumberCountException;
import lotto.exception.LottoNumberDuplicatedException;
import lotto.exception.LottoNumberOutOfRangeException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCountException(numbers.size());
        }
        if (new HashSet<>(numbers).size() != LottoConfig.LOTTO_NUMBER_COUNT) {
            throw new LottoNumberDuplicatedException();
        }
        numbers.forEach(this::validateNumber);
    }

    // TODO: 추가 기능 구현
    public void addedToResult(StringJoiner result) {
        result.add(numbers.toString());
    }

    private void validateNumber(int number) {
        if (number < LottoConfig.MIN_LOTTO_NUMBER || number > LottoConfig.MAX_LOTTO_NUMBER) {
            throw new LottoNumberOutOfRangeException(number);
        }
    }

    protected boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbersWith(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containsNumber)
                .count();
    }
}
