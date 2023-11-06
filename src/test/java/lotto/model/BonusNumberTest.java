package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("입력된 보너스 번호가 기존 로또 번호와 중복되면 예외가 발생한다")
    void inputBonusNumbersCheckDuplication() {
        assertThatThrownBy(() -> new BonusNumber(6, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자만 가능합니다");
    }

    @Test
    @DisplayName("입력된 보너스 번호가 1~45 사이가 아니면 예외가 발생한다")
    void inputBonusNumbersOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45까지의 숫자 하나만 가능합니다");
    }
}