package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {

    @DisplayName("유저 지불 금액 유효성 검사 - 1000원 이하의 금액 데이터 - 오류")
    @Test
    void validateUnderMinimumPaymentTest() {
        int paymentAmount = 500;

        assertThatThrownBy(() -> new Payment(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 이상의 구매 금액을 입력해주세요.");
    }

    @DisplayName("유저 지불 금액 유효성 검사 - 1000원 단위가 아닌 금액 데이터 - 오류")
    @Test
    void validateNonDivisiblePaymentTest() {
        int paymentAmount = 1500;

        assertThatThrownBy(() -> new Payment(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위의 구매 금액을 입력해주세요.");
    }

    @DisplayName("유저 지불 금액 유효성 검사 - 정상 데이터 - 성공")
    @Test
    void validatePaymentCorrectTest() {
        int paymentAmount = 2000;
        Payment payment = new Payment(paymentAmount);

        assertThat(payment.providePaymentStatus().get(0)).isEqualTo(paymentAmount);
    }

    @DisplayName("유저 지불 금액 및 구매 수량 테스트 - 정상 데이터 - 성공")
    @Test
    void providePaymentStatusTest() {
        int paymentAmount = 4000;
        List<Integer> expectedResult = List.of(4000, 4);
        Payment payment = new Payment(paymentAmount);

        assertThat(payment.providePaymentStatus()).isEqualTo(expectedResult);
    }
}
