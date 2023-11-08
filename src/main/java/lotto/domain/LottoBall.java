package lotto.domain;

import static lotto.message.ErrorMessages.INVALID_LOTTO_BALL_EMPTY;
import static lotto.message.ErrorMessages.INVALID_LOTTO_BALL_FORMAT;
import static lotto.message.ErrorMessages.INVALID_LOTTO_BALL_RANGE;

public record LottoBall(String lottoBall) {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public LottoBall {
        validateEmptyFromLottoBall(lottoBall);
        validateCharacterFromLottoBall(lottoBall);
        validateRangeFromLottoBall(lottoBall);
    }

    private void validateEmptyFromLottoBall(String lottoBall) {
        if (lottoBall.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LOTTO_BALL_EMPTY.getMessage());
        }
    }

    private void validateCharacterFromLottoBall(String lottoBall) {
        for (int idx = 0; idx < lottoBall.length(); idx++) {
            if (!Character.isDigit(lottoBall.charAt(idx))) {
                throw new IllegalArgumentException(INVALID_LOTTO_BALL_FORMAT.getMessage());
            }
        }
    }

    private void validateRangeFromLottoBall(String lottoBall) {
        int ballNumber = Integer.parseInt(lottoBall);
        if (ballNumber < MIN_LOTTO_NUMBER || ballNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_BALL_RANGE.getMessage());
        }
    }

    public int toInt() {
        return Integer.parseInt(lottoBall);
    }
}
