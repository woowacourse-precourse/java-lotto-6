package lotto;

import static lotto.Model.WinningLotto.ERROR_END_DELEMETER;
import static lotto.Model.WinningLotto.ERROR_NOT_LOTTO_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("숫자와 쉼표로 구성 되지 않은 로또번호는 예외 발생하는 테스트")
    @Test
    void createWinningLotto() {
        String invalidInput = "1,2,3,4,5, 30";

        assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_LOTTO_FORMAT);
    }

    @DisplayName("당첨번호가 쉼표로 끝나면 예외 발생하는 테스트")
    @Test
    void createWinningLotto2() {
        String invalidInput = "1,2,3,4,5,30,";

        assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_END_DELEMETER);
    }
}
