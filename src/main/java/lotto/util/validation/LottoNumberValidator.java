package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER;

import lotto.model.Lotto;

public class LottoNumberValidator extends NumberValidator {
    private LottoNumberValidator() {
    }

    public static LottoNumberValidator getInstance() {
        return LottoNumberValidatorHolder.INSTANCE;
    }

    @Override
    public void validate(final String target) {
        super.validate(target);
        validateLottoNumber(target);
    }

    private void validateLottoNumber(final String target) {
        final int lottoNumber = Integer.parseInt(target);
        if ((lottoNumber < Lotto.MIN_LOTTO_NUMBER) || (lottoNumber > Lotto.MAX_LOTTO_NUMBER)) {
            throwFail(INVALID_LOTTO_NUMBER.format(lottoNumber));
        }
    }

    private static class LottoNumberValidatorHolder {
        private static final LottoNumberValidator INSTANCE = new LottoNumberValidator();
    }
}
