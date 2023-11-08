package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    Money money;

    @BeforeEach
    void setUp() {
        // 모든 테스트에 공통으로 사용될 변수 설정
        money = new Money(100_000_000L);
    }

    @DisplayName("돈의 합 연산 결과가 정확한지 확인합니다.")
    @Test
    void sum() {
        Money expected = new Money(150_000_000L);
        Money actual = money.sum(new Money(50_000_000L));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("돈의 곱하기 연산 결과가 정확한지 확인합니다.")
    @Test
    void multiplyByCount() {
        Money expected = new Money(1_000_000_000L);
        Money actual = money.multiplyByCount(10L);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자의 대소비교 결과가 정확한지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"99_999_999/false", "100_000_001/true"}, delimiter = '/')
    void isLessThan(long amount, boolean expectedResult) {
        assertThat(money.isLessThan(new Money(amount))).isEqualTo(expectedResult);
    }

    @DisplayName("숫자가 나누어 떨어지는지에 대한 여부가 정확한지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"10_000_000/false", "9999/true"}, delimiter = '/')
    void cantDividedBy(long amount, boolean expectedResult) {
        assertThat(money.cantDividedBy(new Money(amount))).isEqualTo(expectedResult);
    }

    @DisplayName("퍼센티지를 구하는 연산의 결과가 정확한지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"165_000_000/60.6", "123_456_789/81.0"}, delimiter = '/')
    void getPercentageOf(long amount, double expectedResult) {
        // 오차범위를 0.01로 설정
        double tolerance = 0.01;

        assertThat(money.getPercentageOf(new Money(amount)))
                .isCloseTo(expectedResult, within(tolerance));

    }
}