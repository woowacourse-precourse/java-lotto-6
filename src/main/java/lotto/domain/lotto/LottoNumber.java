package lotto.domain.lotto;

import static lotto.config.GameConfig.MAXIMUM_LOTTO_NUMBER;
import static lotto.config.GameConfig.MINIMUM_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_RANGE_INVALID;

public class LottoNumber {

    private Integer lottoNumber;

    private LottoNumber(Integer lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber create(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private static void validateLottoNumber(Integer lottoNumber) {
        validateLottoNumberRange(lottoNumber);
    }

    private static void validateLottoNumberRange(Integer lottoNumber) {
        if (isNumberRangeInvalid(lottoNumber)) {
            throw new IllegalArgumentException(String.format(
                    LOTTO_NUMBER_RANGE_INVALID.getMessage(),
                    MINIMUM_LOTTO_NUMBER.getNumber(),
                    MAXIMUM_LOTTO_NUMBER.getNumber())
            );
        }
    }

    private static boolean isNumberRangeInvalid(Integer lottoNumber) {
        return lottoNumber < MINIMUM_LOTTO_NUMBER.getNumber() || lottoNumber > MAXIMUM_LOTTO_NUMBER.getNumber();
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}
