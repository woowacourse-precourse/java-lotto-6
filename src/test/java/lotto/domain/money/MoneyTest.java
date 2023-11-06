package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoneyTest {
    @DisplayName("금액을 컴마로 구분하고, 원을 붙인 문자열로 정확하게 변환하는지 확인")
    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void toString(long amount, String expectedResult) {
        Money money = new Money(amount);
        assertThat(money.toString()).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(1L, "1원"),
                arguments(10L, "10원"),
                arguments(100L, "100원"),
                arguments(1000L, "1,000원"),
                arguments(10000L, "10,000원"),
                arguments(100000L, "100,000원"),
                arguments(1000000L, "1,000,000원"),
                arguments(10000000L, "10,000,000원"),
                arguments(100000000L, "100,000,000원"),
                arguments(1000000000L, "1,000,000,000원"),
                arguments(10000000000L, "10,000,000,000원")
        );
    }
}