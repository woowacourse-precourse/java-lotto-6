package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {


    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningLottoByDuplicateNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 범위에서 벗어나면 예외가 발생한다.")
    void createWinningLottoByInvalidRangeNumber() {
        int invalidRangeNumber = WinningLotto.UPPER_BOUND_OF_BONUS_NUMBER + 1;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), invalidRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
