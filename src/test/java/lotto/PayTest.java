package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import lotto.domain.Pay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PayTest {
    @DisplayName("사용자 지불액 정상 흐름")
    @Test
    void createPay() {
        assertThatCode(() -> new Pay("1000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("지불 금액이 음수면 예외가 발생한다.")
    @Test
    void createPayByNegativeNumber() {
        assertThatThrownBy(() -> new Pay("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NEGATIVE.getMessage());
    }

    @DisplayName("지불 금액이 소수면 예외가 발생한다.")
    @Test
    void createPayByDecimal() {
        assertThatThrownBy(() -> new Pay("1.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("지불 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createPayByNonNumber() {
        assertThatThrownBy(() -> new Pay("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("지불 금액이 로또 금액 미만이면 예외가 발생한다.")
    @Test
    void createPayByNotEnoughNumber() {
        assertThatThrownBy(() -> new Pay("300"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LESS_THAN_PRICE.getMessage());
    }

    @DisplayName("지불 금액이 로또를 구매하고 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createPayByCanNotDivideNumber() {
        assertThatThrownBy(() -> new Pay("1201"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAN_NOT_DIVIDE.getMessage());
    }
}
