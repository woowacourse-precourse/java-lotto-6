package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @ValueSource(ints = {6, 46, 0})
    @DisplayName("입력된 보너스 번호의 값을 검증한다. 범위 밖 숫자이거나 중복된 숫자일 경우 예외가 발생한다.")
    @ParameterizedTest
    void checkBonusNumberInput(int bonusNumber) {
        Lotto numbers = Lotto.validate(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> WinningNumber.validate(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
