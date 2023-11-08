package lotto.domain.model;

import java.util.List;

public class Lotto {
    public static final int LOTTO_BALLS_SIZE = 6;
    public static final int LOTTO_BALL_MIN_RANGE = 1;
    public static final int LOTTO_BALLS_MAX_RANGE = 45;
    private static final String ERROR_HEAD = "[ERROR]";
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public static Lotto newInstance(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Integer matchUp(Lotto givenLotto) {
        return (int) numbers.stream()
                .filter(givenLotto::haveSameBall)
                .count();
    }

    public boolean haveSameBall(Integer number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbersForMessage() {
        return numbers;
    }

    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_BALLS_SIZE) {
            throw new IllegalArgumentException(ERROR_HEAD);
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ERROR_HEAD);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < LOTTO_BALL_MIN_RANGE || number > LOTTO_BALLS_MAX_RANGE)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERROR_HEAD);
                });
    }
}
