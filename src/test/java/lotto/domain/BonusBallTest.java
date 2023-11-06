package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallTest {
    @ParameterizedTest()
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 볼의 숫자가 1~45 로 이루어지지 않으면 예외가 발생한다.")
    void rangeBonusBall(int number) {
        assertThatThrownBy(() -> new BonusBall(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}