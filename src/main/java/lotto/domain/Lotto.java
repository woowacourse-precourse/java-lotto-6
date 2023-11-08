package lotto.domain;

import static lotto.domain.LottoConstants.MAX_NUMBER;
import static lotto.domain.LottoConstants.MIN_NUMBER;
import static lotto.domain.LottoConstants.NUMBER_COUNT;
import static lotto.error.ExceptionCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER_COUNT;

import java.util.List;
import lotto.error.LottoException;

public class Lotto {

    private final static String NUMBER_STRING_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoException(INVALID_LOTTO_NUMBER_COUNT);
        }
        numbers.forEach(this::validateNumber);
        validateNoDuplicatedNumbers(numbers);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(INVALID_LOTTO_NUMBER);
        }
    }

    private void validateNoDuplicatedNumbers(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    public Prize getPrize(final WinnerNumbers winnerNumbers) {
        return Prize.of(calculateSameCount(winnerNumbers), calculateSameBonusCount(winnerNumbers));
    }

    private long calculateSameCount(final WinnerNumbers winnerNumbers) {
        return numbers.stream().filter(winnerNumbers::containNumber).count();
    }

    private long calculateSameBonusCount(final WinnerNumbers winnerNumbers) {
        return numbers.stream().filter(winnerNumbers::containBonusNumber).count();
    }

    public String getNumberString() {
        final List<String> numberStrings = numbers.stream().map(String::valueOf).toList();
        return String.join(NUMBER_STRING_DELIMITER, numberStrings);
    }
}
