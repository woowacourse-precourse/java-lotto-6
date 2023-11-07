package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 44, 45})
    @DisplayName("범위 내의 수로 생성하는 경우 정상적으로 생성된다.")
    public void validRangeTest(int number) {
        assertDoesNotThrow(() -> LottoBall.getInstance(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50, 100})
    @DisplayName("범위를 벗어나게 생성하는 경우, 예외를 발생한다.")
    public void invalidRangeTest(int number) {
        assertThatThrownBy(() -> LottoBall.getInstance(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
