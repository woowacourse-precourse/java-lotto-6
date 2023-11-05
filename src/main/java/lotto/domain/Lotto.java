package lotto.domain;

import static lotto.domain.LottoConstants.MAX_NUMBER;
import static lotto.domain.LottoConstants.MIN_NUMBER;
import static lotto.domain.LottoConstants.NUMBER_COUNT;

import java.util.List;

public class Lotto {

    private final static String NUMBER_STRING_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(this::validateNumber);
        validateNoDuplicatedNumbers(numbers);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedNumbers(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
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
