package lotto.validator.view_layer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersValidatorTest {
    //CommonValidator와 LottoValidator에서 전부 테스트 된 내용인데 이거를 테스트하는게 맞나?

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
