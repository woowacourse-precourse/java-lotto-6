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
                .hasMessage("[ERROR] 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 숫자가 45보다 크면 안 된다.")
    @Test
    void createWinningLottoByOverNumberRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "4", "44", "56", "43", "23")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 숫자가 1보다 작으면 안 된다.")
    @Test
    void createWinningLottoByUnderNumberRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "-6", "30", "29", "32")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotSixSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개여야만 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복된 숫자를 고를 수 없습니다.");
    }
}