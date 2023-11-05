package lotto.dto.request;

import static lotto.common.ErrorMessages.NOT_A_NUMBER;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;
import static lotto.utils.StringUtils.isDigit;
import static org.junit.platform.commons.util.StringUtils.isBlank;

import lotto.exception.InputValidationException;

public class LottoNumberRequest {
    private int lottoNumber;

    public LottoNumberRequest(String lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validateLottoNumber(String lottoNumber) {
        if (isBlank(lottoNumber)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!isDigit(lottoNumber)) {
            throw new InputValidationException(NOT_A_NUMBER);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
