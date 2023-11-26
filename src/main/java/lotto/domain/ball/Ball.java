package lotto.domain.ball;

import lotto.domain.ball.validator.BallValidator;

public class Ball {

    private final int number;

    public Ball(final int number) {
        BallValidator.validateBall(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
