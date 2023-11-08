package domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Nested
    class InvalidRangeTests {

        @ParameterizedTest
        @DisplayName("유효하지 않은 숫자 범위 테스트")
        @ValueSource(ints = {-1, 0, 46, 100})
        public void invalidRangeTest(int number) {
            assertThatThrownBy(() -> new LottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("유효한 숫자 범위 테스트")
        @ValueSource(ints = {1, 2, 44, 45})
        public void validRangeTest(int number) {
            assertThatCode(() -> new LottoNumber(number))
                    .doesNotThrowAnyException();
        }
    }
}
