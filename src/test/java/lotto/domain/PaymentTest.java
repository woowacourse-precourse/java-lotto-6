package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PaymentTest {

    @DisplayName("조건을 만족한 금액으로만 구입 가능")
    @Test
    void wrongPayAmount() {
        assertThatThrownBy(() -> new Payment(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PAYMENT.message());
    }

    @DisplayName("금액에 따른 로또 발행 수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "15000,15"})
    void getLottoCount(int payAmount, int expectedNum) {
        Payment payment = new Payment(payAmount);
        assertThat(payment.getLottoCount()).isEqualTo(expectedNum);
    }
}