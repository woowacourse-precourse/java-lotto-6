package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_OVER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호가 범위(1~45)를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47})
    void createLottoNumberByOverRange(int wrongNumber) {
        assertThatThrownBy(() -> new LottoNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OVER_RANGE);
    }

}