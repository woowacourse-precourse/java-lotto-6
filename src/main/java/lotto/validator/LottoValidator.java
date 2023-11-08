package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.exception.InvalidLottoNumberException;

public final class LottoValidator {

    private LottoValidator() {

    }

    public static void validateLottoNumberInRange(Integer lottoNumber) {
        if (isOutOfRange(lottoNumber)) {
            throw new InvalidLottoNumberException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private static Boolean isOutOfRange(Integer lottoNumber) {
        return lottoNumber < LottoConstant.LOTTO_NUMBER_MIN.getValue()
            || lottoNumber > LottoConstant.LOTTO_NUMBER_MAX.getValue();
    }
}
