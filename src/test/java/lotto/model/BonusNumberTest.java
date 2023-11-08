package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.model.exceptions.OutOfRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-100, -10, 0, 46, 100})
    @DisplayName("범위 밖의 숫자 예외 발생")
    void outOfRangeNumberInput(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(OutOfRangeNumberException.class);
    }
}