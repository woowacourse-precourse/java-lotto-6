package lotto.util;

import java.util.List;

import static lotto.constant.ConstantValue.END_INCLUSIVE;
import static lotto.constant.ConstantValue.START_INCLUSIVE;

public class LottoValidator {

    public static void validateLotto(List<Integer> lottoNumbers) {
        // 여기까지 왔다면 로또의 숫자는 모두 Integer이기는 하다.
        // 범위가 1 ~ 45인지
        // 입력값 안에 중복 입력은 없는지
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
