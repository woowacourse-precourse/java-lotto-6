package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {

    @Test
    @DisplayName("정상 작동 케이스")
    void testWinningLottoByValidCase() {
        String validWinningLotto = "1,2,3,4,5,6";

        assertThatCode(() -> WinningLottoValidator.validateWinningLotto(validWinningLotto))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 들어가면 예외 발생")
    void testWinningLottoWithNonInteger() {
        String invalidWinningLotto = "ho,1,2,3,4,5";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinningLottoValidator.validateWinningLotto(invalidWinningLotto))
                .withMessage("[ERROR] 로또 넘버는 숫자여야 합니다.");
    }
}