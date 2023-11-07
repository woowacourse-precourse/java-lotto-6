package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_COUNT
        );

        return new Lotto(generatedNumbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void validate(List<Integer> numbers) {
        validateSizeFrom(numbers);
        validateDuplicateFrom(numbers);
    }

    private void validateSizeFrom(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_NUMBER_LENGTH.message);
        }
    }

    private void validateDuplicateFrom(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_DUPLICATE_NUMBER.message);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
