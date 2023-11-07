package lotto.domain;

import java.util.List;
import lotto.exception.InvalidLengthException;

public class Lotto {
    public static final int LOTTO_BALL_COUNT = 6;

    private final List<LottoBall> numbers;

    public Lotto(List<LottoBall> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoBall> numbers) {
        validateLength(numbers);
    }

    private void validateLength(List<LottoBall> numbers) {
        if (numbers.size() != LOTTO_BALL_COUNT) {
            throw new InvalidLengthException();
        }
    }

}
