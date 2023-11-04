package lotto.domain;

import java.util.List;

public class Lotto {

    public final static Integer MIN_NUMBER = 1;

    public final static Integer MAX_NUMBER = 45;

    public final static int NUMBER_COUNT = 6;

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
