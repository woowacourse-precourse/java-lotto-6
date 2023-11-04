package lotto.validator;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_MESSAGE;

import java.util.List;
import lotto.view.Output;

public class LotteryResultValidator {
    public static void bonusNumberDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            Output.errorMessage(BONUS_NUMBER_DUPLICATED_MESSAGE);
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }

    }
}
