package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 숫자는 1에서 45 이하의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 46, 50})
    void BonusNumber_Constructor_ThrowsException_For_NumberOutOfRange(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
