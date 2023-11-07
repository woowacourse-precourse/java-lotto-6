package lotto.model;

import lotto.service.PriceValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceValidatorTest {

    String price = "1500";

    @DisplayName("로또 구매 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    void validatePrice() {
        assertThatThrownBy(() -> PriceValidator.validate(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 숫자가 아닌 경우 예외 발생")
    @Test
    void validatePriceByNotNumber() {
        assertThatThrownBy(() -> PriceValidator.validate("2000won"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매액에 따른 티켓 개수 반환")
    @Test
    void getTicketCount() {
        price = "5000";
        assertEquals(5, PriceValidator.validate(price));

    }
}