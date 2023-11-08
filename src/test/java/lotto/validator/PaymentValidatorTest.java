package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {
    @DisplayName("부족한 가격이 입력되면 예외가 발생한다.")
    @Test
    void buyLottoAtNotEnoughPrice() {
        assertThatThrownBy(() -> PaymentValidator.validate("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("거스름돈이 발생하면 예외가 발생한다.")
    @Test
    void existChange() {
        assertThatThrownBy(() -> PaymentValidator.validate("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
