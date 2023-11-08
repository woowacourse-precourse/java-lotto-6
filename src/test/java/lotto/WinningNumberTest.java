package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7).toString()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumberByShortSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5).toString()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5).toString()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 중 1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberByRange() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46).toString()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 문자가 있으면 예외가 발생한다.")
    void createWinningNumberByType() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, "ㅓ", 3, 4, 5, 45).toString()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
