package lotto.validator;

import static java.lang.Integer.parseInt;
import static lotto.view.message.ErrorMessage.DUPLICATED_NUMBER_IN_WINNING_LOTTO;

import java.util.List;
import lotto.domain.Lotto;

public class BonusValidator {
    public static void validate(String bonus, Lotto winningLotto) {
        InputValidator.validateEmpty(bonus);
        InputValidator.validateDigit(bonus);
        InputValidator.validateNumberOnlyFromOneToFortyFive(parseInt(bonus));
        validateDuplicatedNumberInWinningLotto(parseInt(bonus), winningLotto);
    }

    private static void validateDuplicatedNumberInWinningLotto(int bonus, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_IN_WINNING_LOTTO.getErrorMessage());
        }
    }
}
