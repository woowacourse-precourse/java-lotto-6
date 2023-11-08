package lotto.domain;

import static lotto.domain.LottoConstants.MAX_NUMBER;
import static lotto.domain.LottoConstants.MIN_NUMBER;
import static lotto.domain.LottoConstants.NUMBER_COUNT;
import static lotto.error.ExceptionCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.error.LottoException;

public class WinnerNumbers {

    private final List<Integer> numbers;

    private final Integer bonusNumber;

    public WinnerNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;

    }

    private void validate(final List<Integer> numbers, final Integer bonusNumber) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoException(INVALID_LOTTO_NUMBER_COUNT);
        }
        numbers.forEach(this::validateNumber);
        validateNumber(bonusNumber);
        validateNoDuplicatedNumbers(numbers, bonusNumber);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(INVALID_LOTTO_NUMBER);
        }
    }

    private void validateNoDuplicatedNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        final List<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
        numbersWithBonusNumber.add(bonusNumber);
        if (numbersWithBonusNumber.stream().distinct().count() != numbersWithBonusNumber.size()) {
            throw new LottoException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    public boolean containNumber(final Integer number) {
        return numbers.contains(number);
    }

    public boolean containBonusNumber(final Integer number) {
        return bonusNumber.equals(number);
    }
}
