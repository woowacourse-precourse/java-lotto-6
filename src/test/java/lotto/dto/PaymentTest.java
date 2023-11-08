package lotto.dto;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @DisplayName("null값 입력시 예외가 발생")
    @Test
    void createPaymentByNull() {
        assertThatThrownBy(() -> BonusNumber.create(""))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("잔돈이 생기는 경우 예외 발생")
    @Test
    void createPaymentForRemainder() {
        assertThatThrownBy(() -> Payment.create("1001"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("정수가 아닌 값 입력 시 예외 발생")
    @Test
    void createNotInteger(){
        assertThatThrownBy(() -> Payment.create("정수가 아님"))
                .isInstanceOf(LottoGameException.class);
    }
}
