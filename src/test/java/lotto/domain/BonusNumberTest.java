package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("범위 내 숫자가 아니면 예외 발생.")
    @Test
    void createBonusNumberByOutOfRangeNumbers() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}