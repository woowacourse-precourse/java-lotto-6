package lotto.domain.lotto.validator;

import lotto.domain.constant.Constant;
import lotto.exception.exceptions.CustomIllegalArgumentException;
import lotto.exception.lotto.LottoExceptionStatus;

public class BallValidator {

    private static final BallValidator BALL_VALIDATOR = new BallValidator();

    private BallValidator() {
    }

    public static void validateBall(final int number) {
        BALL_VALIDATOR.validateBallIsOutOfRange(number);
    }

    private void validateBallIsOutOfRange(final int number) {
        if (isOutOfRange(number)) {
            throw new CustomIllegalArgumentException(LottoExceptionStatus.LOTTO_IS_OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(final int number) {
        return Constant.ALLOWED_MINIMUM_NUMBER.getConstant() > number
                || Constant.ALLOWED_MAXIMUM_NUMBER.getConstant() < number;
    }
}
