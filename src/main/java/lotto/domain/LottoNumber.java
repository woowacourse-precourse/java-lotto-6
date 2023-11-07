package lotto.domain;

import static lotto.exception.ExceptionMessage.OUT_OF_LOTTO_NUMBER_LENGTH;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumberLength(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberLength(int lottoNumber) {
        if((lottoNumber < 1) || ( lottoNumber > 46)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_LENGTH.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}