package lotto.util;

import java.util.List;

import static lotto.constant.ConstantValue.END_INCLUSIVE;
import static lotto.constant.ConstantValue.START_INCLUSIVE;

public class LottoValidator {

    public static void validateLotto(List<Integer> lottoNumbers) {
        validateLottoNumbersOutOfRange(lottoNumbers);
    }

    private static void validateLottoNumbersOutOfRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateLottoNumberOutOfRange(lottoNumber);
        }
    }

    private static void validateLottoNumberOutOfRange(Integer lottoNumber) {
        if (lottoNumber < START_INCLUSIVE || lottoNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }
}
