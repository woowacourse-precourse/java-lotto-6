package lotto.core.lottoBall.domain;

import java.util.Objects;
import lotto.core.lottoBall.exception.InvalidLottoBallRangeException;

public class LottoBall implements Comparable<LottoBall> {

    private static final int MIN_LOTTO_BALL_NUMBER = 1;
    private static final int MAX_LOTTO_BALL_NUMBER = 45;

    private final Integer number;

    public LottoBall(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < MIN_LOTTO_BALL_NUMBER || number > MAX_LOTTO_BALL_NUMBER) {
            throw new InvalidLottoBallRangeException();
        }
    }

    @Override
    public int compareTo(LottoBall o) {
        return number.compareTo(o.number);
    }

    public boolean match(Integer target) {
        return number.equals(target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBall lottoBall = (LottoBall) o;
        return Objects.equals(number, lottoBall.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
