package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("[EXCEPTION]구입금액이 로또 가격보다 작으면 예외가 발생한다.")
    void createPaymentByLessThan1000(int input) {
        int pay = input;

        assertThatThrownBy(() -> new Payment(pay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 로또 개당 가격 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 10001, 12345})
    @DisplayName("[EXCEPTION]구입금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void createPaymentByNotDivisible1000(int input) {
        int pay = input;

        assertThatThrownBy(() -> new Payment(pay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 로또 개당 가격으로 나누어 떨어져야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"8000,8", "12000,12"})
    @DisplayName("[SUCCESS]구입금액을 로또 가격으로 나누어 로또 구매 개수를 구한다.")
    void calculateLottoAmountUsingPay(int input, int expected) {

        // given
        Payment userPay = new Payment(input);

        // when
        int amount = userPay.calculateLottoAmount();

        // then
        assertThat(amount).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"8000, 5000, 62.5"})
    @DisplayName("[SUCCESS]수익금을 이용하여 수익률을 계산한다.")
    void calculateReturnRate(int input, int reward, String expected) {

        // given
        Payment userPay = new Payment(input);

        // when
        String result = userPay.getReturnRate(reward);

        // then
        assertThat(result).isEqualTo(expected);
    }

}