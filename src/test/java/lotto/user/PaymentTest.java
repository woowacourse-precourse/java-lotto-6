package lotto.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumber() {
        Payment payment = new Payment();
        int actualNumber = payment.getMoneyNumber("11000");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumberWithSpace() {
        Payment payment = new Payment();
        int actualNumber = payment.getMoneyNumber("  11000  ");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액이 정수가 아닌 경우")
    @Test
    void getMoneyByNotNumber() {
        Payment payment = new Payment();
        assertThatThrownBy(() -> payment.getMoneyNumber("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 빈 값인 경우")
    @Test
    void getMoneyByNullInput() {
        Payment payment = new Payment();
        assertThatThrownBy(() -> payment.getMoneyNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0인 경우")
    @Test
    void getMoneyNumberByZero() {
        Payment payment = new Payment();
        assertThatThrownBy(() -> payment.getMoneyNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 1,000원 단위가 아닌 경우")
    @Test
    void getMoneyNumberByInvalidUnit() {
        Payment payment = new Payment();
        assertThatThrownBy(() -> payment.getMoneyNumber("11110"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}