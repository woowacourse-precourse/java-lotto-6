package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {

    @Nested
    @DisplayName("숫자 범위 검증 테스트")
    class RangeValidationTest {

        @ParameterizedTest
        @CsvSource({"-1", "0", "46"})
        @DisplayName("로또에서 사용하는 숫자 범위를 벗어난 숫자로 객체를 생성랗 수 없다")
        void rangeValidationTest_whenOutOfRange(int number) {

            assertThatThrownBy(() -> Number.from(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("로또 숫자는 1 이상 45 이하이어야 합니다");
        }

        @ParameterizedTest
        @CsvSource({"1", "45"})
        @DisplayName("로또에서 사용하는 숫자 범위 내에 있는 경우, 정상적으로 객체를 생성한다")
        void rangeValidationTest_whenInRange(int number) {

            assertDoesNotThrow(() -> Number.from(number));
        }
    }
}
