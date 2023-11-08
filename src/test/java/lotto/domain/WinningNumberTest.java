package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("입력한 당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void inputWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(11, 22, 33, 44, 55, 66, 77)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @DisplayName("입력한 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void inputWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATED_WINNING_NUMBER.getMessage());
    }
}