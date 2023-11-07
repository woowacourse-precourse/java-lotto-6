package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("입력받은 로또 번호가 1~45사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateLottoNumbers() {
        // given
        String input = "0,1,2,3,4,5";
        String[] numbers = input.split(",");

        // when & then
        assertThatThrownBy(() -> LottoNumber.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1~45사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateLottoNumber() {
        // given
        String zero = "0";

        // when & then
        assertThatThrownBy(() -> LottoNumber.validateLottoNumber(zero))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
