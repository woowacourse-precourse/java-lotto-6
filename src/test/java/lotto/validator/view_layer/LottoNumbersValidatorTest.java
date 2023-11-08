package lotto.validator.view_layer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersValidatorTest {

    LottoNumbersValidator lottoNumbersValidator = new LottoNumbersValidator();
    @Test
    @DisplayName("로또 번호의 갯수가 LOTTO_SIZE를 넘어가면 안된다")
    void validateLottoSize() {

    }

    @Test
    @DisplayName("로또 번호의 범위는 MIN_LOTTO_NUMBER와 MAX_LOTTO_NUMBER 사이여야한다.")
    void validateLottoNumberRange() {

    }
}
