package lotto.exception;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyExceptionTest {


    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"11599", "2001", "3001", "4001"})
    void wrongMoneyUnitException(String input) {


        Assertions.assertThatThrownBy(() -> Money.of(input))
                  .isInstanceOf(IllegalArgumentException.class);


    }
}
