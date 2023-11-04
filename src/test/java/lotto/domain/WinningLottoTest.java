package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    @DisplayName("글자를 입력하거나 터무니 없는 값을 입력하면 예외가 발생한다.")
    @Test
    void createWinningLottoByNotNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("199388020895830204", "테스트", "111", "403", "3", "9")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 1~45까지의 숫자를 입력해주세요.");
    }
}