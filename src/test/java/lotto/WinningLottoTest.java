package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 번호 입력값에 중간에 공백이 포함되면 예외가 발생한다.")
    @Test
    void inputWinnerNumbersWithSpaces() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3 5, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 문자일 경우 예외가 발생한다.")
    @Test
    void inputWinnerNumbersWithString() {
        assertThatThrownBy(() -> new WinningLotto("1a, 2, 3 5, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 1~45 사이의 번호가 아닐 경우 예외가 발생한다.")
    @Test
    void inputWinnerNumbersOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 60"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void inputWinnerNumbersWithWrongSize() {
        assertThatThrownBy(() ->  new WinningLotto("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값에 중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void inputWinnerNumbersWithDuplicates() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
