package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import Controller.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    @DisplayName("구입 금액이 1,000 단위가 아닐 때 예외 발생")
    @Test
    void priceUnit() {
        ExceptionHandler handler = new ExceptionHandler();
        int wrongPrice = 1050;
        assertThatThrownBy(() -> handler.checkPriceUnit(wrongPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
