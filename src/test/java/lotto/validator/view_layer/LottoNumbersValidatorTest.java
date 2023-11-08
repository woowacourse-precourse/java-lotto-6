package lotto.validator.view_layer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersValidatorTest {
    //CommonValidator와 LottoValidator에서 전부 테스트 된 내용인데 이거를 어떤방식으로 테스트해야될까

    LottoNumbersValidator lottoNumbersValidator = new LottoNumbersValidator();
    @Test
    @DisplayName("올바르지 못한 로또 입력 테스트")
    void validateImproperLottoNumbersInput() {
        String lottoInput1 = "1,2,3,4 ,5 ,6 ,7"; // 기존 로또 사이즈보다 클 때
        String lottoInput2 = ",,,2,4,5,6,11,7"; // 올바르지 못한 포맷
        String lottoInput3 = "15,22,55,11,16,18"; // 로또번호가 레인지(1~45)를 벗어남
        String lottoInput4 = "aa,13,15,16,17,18"; // 문자열이 포함될 때

        assertThatThrownBy(() -> lottoNumbersValidator.validate(lottoInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbersValidator.validate(lottoInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbersValidator.validate(lottoInput3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbersValidator.validate(lottoInput4))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("올바른 로또 입력 테스트")
    void validateProperLottoNumbersInput() {
        String lottoInput1 = "1,2,3,4,5,6";
        String lottoInput2 = "1, 5, 40  , 7 , 3, 11";
        String lottoInput3 = "  11, 16, 19, 33, 21, 9";

        lottoNumbersValidator.validate(lottoInput1);
        lottoNumbersValidator.validate(lottoInput2);
        lottoNumbersValidator.validate(lottoInput3);
    }
}
