package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByOverSize() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 5), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 6, 7), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
