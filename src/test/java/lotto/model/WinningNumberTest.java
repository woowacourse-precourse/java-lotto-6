package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5)));
    }

    @DisplayName("당첨 번호에 1~45범위를 넘은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 46, 5, 5)));
    }

}