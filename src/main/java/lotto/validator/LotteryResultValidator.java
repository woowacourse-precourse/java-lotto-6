package lotto.validator;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_MESSAGE;

import lotto.domain.Lotto;
import lotto.view.Output;

public class LotteryResultValidator {
    public static void bonusNumberDuplicated(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            Output.errorMessage(BONUS_NUMBER_DUPLICATED_MESSAGE);
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }

    }
}
