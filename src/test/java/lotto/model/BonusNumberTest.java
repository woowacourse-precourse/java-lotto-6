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
                .hasMessageContaining("[Error] 보너스 번호는 당첨 번호와 중복되지 않는 숫자만 가능합니다");
    }
}