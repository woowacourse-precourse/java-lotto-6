package lotto.domain;

import lotto.system.SystemMessage;
import lotto.validator.BallValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    public static BonusNumber createManual() {
        while (true) {
            OutputView.printFrom(SystemMessage.INPUT_BONUS_NUMBER);
            try {
                return new BonusNumber(InputView.readInt());
            } catch (IllegalArgumentException e) {
                OutputView.exceptionMessage(e);
            }
        }
    }

    private void validate(int number) {
        BallValidator.validate(number);
    }

    public int get() {
        return number;
    }
}
