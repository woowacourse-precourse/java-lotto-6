package lotto.domain;

import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;
import lotto.system.SystemMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Ball {
    private final int number;

    private Ball(int number) {
        validate(number);
        this.number = number;
    }

    public static Ball from(int number) {
        return new Ball(number);
    }

    public static Ball createManual() {
        while (true) {
            OutputView.printFrom(SystemMessage.INPUT_BONUS_NUMBER);
            try {
                return new Ball(InputView.readInt());
            } catch (IllegalArgumentException e) {
                OutputView.exceptionMessage(e);
            }
        }
    }

    private static void validateRange(int number) {
        if (isUnderRange(number) || isOverRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_RANGE.getMessage());
        }
    }

    private static boolean isUnderRange(int number) {
        return number < LottoNumberConstant.MIN.getValue();
    }

    private static boolean isOverRange(int number) {
        return number > LottoNumberConstant.MAX.getValue();
    }

    private void validate(int number) {
        validateRange(number);
    }

    public int get() {
        return number;
    }
}
