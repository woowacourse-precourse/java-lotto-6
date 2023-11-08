package lotto.domain;

import lotto.exception.RangeLottoException;

public class  BonusBall {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int ball;

    public BonusBall(int ball) {
        validateRange(ball);
        this.ball = ball;
    }

    private void validateRange(int ball) {
        if (ball < MIN_NUMBER || ball > MAX_NUMBER) {
            throw new RangeLottoException();
        }
    }

    public int getBall() {
        return ball;
    }
}
