package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("보너스 번호가 1~45 숫자가 아닐 경우 예외가 발생한다.")
    void createBonusByWrongNumber(int number) {
        assertThatThrownBy(() -> new Bonus(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
