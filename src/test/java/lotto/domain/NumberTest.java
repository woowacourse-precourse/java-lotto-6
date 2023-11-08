package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

            assertThatThrownBy(() -> Number.from(number)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("로또 숫자는 1 이상 45 이하이어야 합니다");
        }

        @ParameterizedTest
        @CsvSource({"1", "45"})
        @DisplayName("로또에서 사용하는 숫자 범위 내에 있는 경우, 정상적으로 객체를 생성한다")
        void rangeValidationTest_whenInRange(int number) {

            assertDoesNotThrow(() -> Number.from(number));
        }
    }

    @Nested
    @DisplayName("동치성 테스트")
    class EqualityTest {

        private static final int EXAMPLE_VALUE = 5;
        private static final int ANOTHER_VALUE = 6;

        @Test
        @DisplayName("같은 인스턴스를 같다고 판단할 수 있다")
        void equalsTest_whenSameInstance() {
            Number number = Number.from(EXAMPLE_VALUE);

            assertThat(number).isEqualTo(number).hasSameHashCodeAs(number);
        }

        @Test
        @DisplayName("다른 클래스의 인스턴스를 다르다고 판단할 수 있다")
        void equalsTest_whenDifferentClass() {
            Number number = Number.from(EXAMPLE_VALUE);
            Object object = new Object();

            assertThat(number).isNotEqualTo(object);
        }

        @Test
        @DisplayName("다른 인스턴스, 값은 값을 가지는 두 객체를 같다도 판단할 수 있다")
        void equalsTest_whenDifferentInstanceSameValue() {
            Number number = Number.from(EXAMPLE_VALUE);
            Number comparedNumber = Number.from(EXAMPLE_VALUE);

            assertThat(number).isEqualTo(comparedNumber).hasSameHashCodeAs(comparedNumber);
        }

        @Test
        @DisplayName("다른 인스턴스, 다른 값을 가지는 두 객체를 같다도 판단할 수 있다")
        void equalsTest_whenDifferentInstanceDifferentValue() {
            Number number = Number.from(EXAMPLE_VALUE);
            Number comparedNumber = Number.from(ANOTHER_VALUE);

            assertThat(number).isNotEqualTo(comparedNumber);
        }
    }

    @Nested
    @DisplayName("숫자 비교 기능 테스트")
    class ComparableTest {

        @Test
        @DisplayName("숫자를 작은 수와 큰 수를 비교할 수 있다")
        void compareToTest() {
            Number three = Number.from(3);
            Number four = Number.from(4);
            Number five = Number.from(5);

            assertThat(four).isLessThan(five).isGreaterThan(three);
        }
    }
}
