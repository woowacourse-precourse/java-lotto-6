package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseAmountTest {


    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("구입 금액이 문자일 경우", "lotto"),
                Arguments.of("구입 금액이 1000 미만일 경우", "300"),
                Arguments.of("구입 금액이 1000 으로 나누어 떨어지지 않을 경우", "1500"),
                Arguments.of("구입 금액이 음수일 경우", "-1000")
        );
    }

    @DisplayName("잘못된 구입 금액일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("parameters")
    void validatePurchaseAmount(String testName, String amount) {
        // given
        // when, then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}