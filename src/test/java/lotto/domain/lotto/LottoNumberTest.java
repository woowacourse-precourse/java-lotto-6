package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.global.constant.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 23})
    void 로또_번호의_범위가_1부터_45사이면_정상적으로_객체_생성(int number) {
        assertEquals(new LottoNumber(number).getClass(), LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void 로또_번호의_범위가_1부터_45사이가_아니면_예외_발생(int number) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getText());
    }

}
