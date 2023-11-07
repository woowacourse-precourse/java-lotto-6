package lotto.validator;

import lotto.Lotto;
import lotto.constant.ErrorMessage;

import static lotto.constant.ErrorMessage.WINNING_LOTTO_CONTAIN_BONUS_NUMBER;

public class BonusNumberValidator implements InputValidator {
    private Lotto winningLotto;

    public BonusNumberValidator(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    @Override
    public void validate(String input) {
        CommonValidator.validateIsNaturalNumber(input);

        int bonusNumber = Integer.parseInt(input);

        LottoValidator.validateRangeOfNumber(bonusNumber);

        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_LOTTO_CONTAIN_BONUS_NUMBER);
        }
    }
}
