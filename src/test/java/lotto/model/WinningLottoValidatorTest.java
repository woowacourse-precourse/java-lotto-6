package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;

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

}