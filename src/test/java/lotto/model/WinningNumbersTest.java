package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백이 포함되어 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersWithBlank() {
        assertThatThrownBy(() -> new WinningNumbers("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 온전하게 작성하지 않으면(콤마로 끝나면) 예외가 발생한다.")
    @Test
    void createWinningNumbersEndWithComma() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumbersLeakOfSize() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}