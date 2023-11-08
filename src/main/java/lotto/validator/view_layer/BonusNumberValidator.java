package lotto.validator.view_layer;

import lotto.domain.Lotto;
import lotto.validator.LottoValidator;

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
