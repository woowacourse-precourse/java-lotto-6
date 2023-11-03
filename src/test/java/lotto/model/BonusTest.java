package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @DisplayName("보너스 숫자가 1부터 45가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} value : {0}")
    @ValueSource(ints = {0, 46, 1000})
    void createOutOfRange(Integer value) {
        assertThatThrownBy(() -> new Bonus(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}