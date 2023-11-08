package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusNumberTest {
    @DisplayName("로또 번호가 1미만 45초과인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -10})
    void createBonusNumberByOverRange(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1이상 45이하인 경우 예외가 발생하지 않는다..")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 20})
    void createBonusNumberByRightRange(int input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertEquals(bonusNumber.number(), input);
    }
}