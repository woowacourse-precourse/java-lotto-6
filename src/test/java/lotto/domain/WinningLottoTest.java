package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("글자를 입력하거나 터무니 없는 값을 입력하면 예외가 발생한다.")
    @Test
    void createWinningLottoByNotNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("테스트!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 1~45까지의 숫자를 입력해주세요.");
    }
}