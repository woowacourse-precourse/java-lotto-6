package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    @Test
    @DisplayName("보너스 숫자가 0과 45 사이가 아닐때")
    void winningLottoValidationTestSpecialNumberOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), 47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NUMBER_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자가 기존 6개 숫자와 겹칠때")
    void winnngLottoBonusNumberIsNotUnique() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_REDUNDANT.getMessage());
    }
}
