package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @DisplayName("보너스 번호의 범위가 유효하면 예외가 발생하지 않는다.")
    @Test
    void createBonusNumber() {
        int number = 1;

        assertDoesNotThrow(() -> new BonusNumber(number));
    }

    @DisplayName("보너스 번호가 1 미만이거나 45 초과이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createBonusNumberByInvalidRange(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
