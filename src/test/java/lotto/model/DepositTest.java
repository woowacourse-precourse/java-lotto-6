package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DepositTest {
    private static Stream<Arguments> normalDepositAmountArguments() {
        return Stream.of(
                Arguments.arguments("1000", 1),
                Arguments.arguments("8000", 8),
                Arguments.arguments("100000", 100),
                Arguments.arguments("001000", 1)
        );
    }

    private static Stream<Arguments> exceptionDepositAmountArguments() {
        return Stream.of(
                Arguments.arguments("숫자가 아닌 값인 경우 1", "1 000"),
                Arguments.arguments("숫자가 아닌 값인 경우 2", "thousand"),
                Arguments.arguments("숫자가 아닌 값인 경우 3", "1_000"),
                Arguments.arguments("1,000원으로 나누어 떨어지지 않는 경우", "1200"),
                Arguments.arguments("입력 값이 너무 큰 경우", "101000"),
                Arguments.arguments("입력 값이 1,000원 미만인 경우", "900"),
                Arguments.arguments("음수인 경우", "-1000"),
                Arguments.arguments("공백인 경우", ""),
                Arguments.arguments("Int 범위 밖의 숫자인 경우", "2147483648")
        );
    }

    @ParameterizedTest(name = "구입 금액 : {0}, 결과 : {1}")
    @MethodSource("normalDepositAmountArguments")
    @DisplayName("정상적인 구입 금액 테스트")
    void normalDepositAmountTest(String depositAmount, Integer purchaseAmount) {
        // when
        Deposit deposit = new Deposit(depositAmount);

        // then
        assertThat(deposit.calculateBuyableLottoAmount())
                    .isEqualTo(purchaseAmount);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("exceptionDepositAmountArguments")
    @DisplayName("예외적인 구입 금액 테스트")
    void exceptionPurchaseAmountTest(String testName, String depositAmount) {
        // when, then
        assertThatThrownBy(() -> new Deposit(depositAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
