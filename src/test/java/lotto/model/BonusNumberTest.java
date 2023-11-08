package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.model.exceptions.OutOfRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = {-100, -10, 0, 46, 100})
    @DisplayName("범위 밖의 숫자 예외 발생")
    void outOfRangeNumberInputTest(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(OutOfRangeNumberException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = {1, 2, 3, 44, 45})
    @DisplayName("범위 내 숫자 예외 발생 X")
    void InRangeNumberInputTest(int input) {
        assertThatCode(() -> new BonusNumber(input))
                .doesNotThrowAnyException();
    }
}