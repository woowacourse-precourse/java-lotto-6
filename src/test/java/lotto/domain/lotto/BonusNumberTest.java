package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @DisplayName("보너스 번호는 1에서 45까지의 범위에 있지 않으면 예외 발생")
    @ValueSource(ints = {-18, 0, 99, 500, 46, 40000})
    void should_Throw_Exception_For_Out_Of_Range(int input) {
        assertThatThrownBy(() -> BonusNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}