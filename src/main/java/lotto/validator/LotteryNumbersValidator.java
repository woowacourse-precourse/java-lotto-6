package lotto.validator;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_MESSAGE;

import lotto.domain.Lotto;
import lotto.view.Output;

/*
 *  당첨번호들(당첨 번호 + 보너스 번호)간의 검증을 담당
 * */

public class LotteryNumbersValidator {
    public static void bonusNumberDuplicated(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            Output.errorMessage(BONUS_NUMBER_DUPLICATED_MESSAGE);
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }

    }
}
