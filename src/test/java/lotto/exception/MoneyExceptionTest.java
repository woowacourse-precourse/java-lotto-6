package lotto.exception;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyExceptionTest {


    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"11599", "2001", "3001", "4001"})
    void wrongMoneyUnitException(String input) {


        Assertions.assertThatThrownBy(() -> Money.valueOf(input))
                  .isInstanceOf(IllegalArgumentException.class);


    }

    @DisplayName("금액이 자연수가 아니면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000", "-2000"})
    void NegativeMoneyUnitException(String input) {


        Assertions.assertThatThrownBy(() -> Money.valueOf(input))
                  .isInstanceOf(IllegalArgumentException.class);


    }
}
