package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import Controller.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    @DisplayName("price 검증 테스트")
    @Test
    public void inputPrice() {
        int price = 555;

        assertThatThrownBy(() -> exceptionHandler.checkPriceUnit(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonusNumber 검증 테스트")
    @Test
    public void inputBonusNumber() {
        int number = 100;

        assertThatThrownBy(() -> exceptionHandler.checkNumberBoundary(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
