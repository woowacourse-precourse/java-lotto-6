package lotto.model.validator;

import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class WinningLottoValidator implements ModelValidator {
    private static WinningLottoValidator winningLottoValidator;

    private WinningLottoValidator() {
    }

    public static WinningLottoValidator getInstance() {
        if (winningLottoValidator == null) {
            winningLottoValidator = new WinningLottoValidator();
            return winningLottoValidator;
        }
        return winningLottoValidator;
    }

    @Override
    public void validate(Object o) {
        if (o instanceof WinningLotto) {
            validate((WinningLotto) o);
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_PROPER_OBJECT_TYPE.getMessage());
    }

    public void validate(WinningLotto winningLotto) {
        validateNull(winningLotto);
        validateNumberInRange(winningLotto.getBonusNumber());
        validateDuplication(winningLotto.getLotto(), winningLotto.getBonusNumber());
    }

    private void validateNull(WinningLotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ENTERED.getMessage());
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    private void validateDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }
}