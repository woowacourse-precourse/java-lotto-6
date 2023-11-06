package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        validateSixNumbers(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateSixNumbers(final List<LottoNumber> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers.toString());
        }
    }

    private boolean hasSixNumbers(final List<LottoNumber> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private void validateDuplicates(final List<LottoNumber> numbers) {
        if (hasDuplicates(numbers)) {
            throw new ExistDuplicatedNumberException(numbers.toString());
        }
    }

    private boolean hasDuplicates(final List<LottoNumber> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();

        return distinctCount != numbers.size();
    }

    public int countCorrectNumbers(final List<LottoNumber> numbers) {

        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(final LottoNumber bonusNumber) {

        return numbers.stream()
                .anyMatch(number -> number.equals(bonusNumber));
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
