package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
class LottoBonusNumberTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumbersDuplicatedWithWinningNumber() {
        assertThatThrownBy(() -> new LottoBonusNumber(1,List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1이상 45 이하의 수가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumbersByOverRange() {
        assertThatThrownBy(() -> new LottoBonusNumber(46,List.of(1, 2, 3, 4, 5, 123)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoBonusNumber(0, List.of(1, 2, 3, 4, 5, 123)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}