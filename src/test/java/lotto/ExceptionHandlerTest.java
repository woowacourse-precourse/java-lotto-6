package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import Controller.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {

    @DisplayName("price 검증 테스트")
    @Test
    public void inputPrice() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        int price = 555;

        assertThatThrownBy(() -> exceptionHandler.checkPriceUnit(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
