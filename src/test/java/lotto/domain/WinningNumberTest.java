package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 에러 메시지를 출력한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(11, 12, 13, 14, 15))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(41,42,43,44,45,45))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}