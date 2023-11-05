package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRangeNumber() {
        int input = 0;

        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}