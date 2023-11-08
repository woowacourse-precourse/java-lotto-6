package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static lotto.handler.ErrorHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    private static Stream<Arguments> generateTicket() {
        return Stream.of(
                Arguments.of(Money.create("3000"), 3),
                Arguments.of(Money.create("20000"), 20),
                Arguments.of(Money.create("50000000"), 50000)
        );
    }

    @DisplayName("구입 금액에 숫자로 변환될 수 없는 타입이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"200j0", "199@", "200 ", "20공0"})
    void createMoneyByInconvertibleType(String inputValue) {
        assertThatThrownBy(() -> Money.create(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCONVERTIBLE_TYPE.getException().getMessage());
    }

    @DisplayName("구입 금액에 0원 이하의 값이 들어오면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"0", "-1", "-50"})
    void createMoneyByInvalidInput(String inputValue) {
        assertThatThrownBy(() -> Money.create(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NEGATIVE_INPUT.getException().getMessage());
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1999", "1258", "2101"})
    void createMoneyByInvalidDivision(String inputValue) {
        assertThatThrownBy(() -> Money.create(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DIVISION.getException().getMessage());
    }

    @DisplayName("정상적으로 값이 들어오는 경우 티켓 개수를 정상 반환한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("generateTicket")
    void createMoney(Money money, int ticket) {
        assertThat(money.getTicket()).isEqualTo(ticket);
    }
}
