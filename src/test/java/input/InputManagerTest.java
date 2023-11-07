package input;

import Controller.InputManager;
import Utils.Messages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputManagerTest {

    private final InputManager inputManager = new InputManager();

    @Test
    @DisplayName("유효한 결제 금액이면 예외를 던지지 않는다")
    void validatePayment_WhenPositiveAndMultipleOfThousand_NoException() {

        // given
        int validPayment = 3000;

        // when & then
        assertDoesNotThrow(() -> inputManager.validatePayment(validPayment));
    }

    @Test
    @DisplayName("결제 금액이 음수이면 IllegalArgumentException을 던진다")
    void validatePayment_WhenNegative_ThrowsException() {

        // given
        int invalidPayment = -1000;

        // when
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputManager.validatePayment(invalidPayment)
        );

        //then
        assertEquals(Messages.NonPositiveAmountException, thrown.getMessage());
    }

    @Test
    @DisplayName("결제 금액이 1000원의 배수가 아니면 IllegalArgumentException을 던진다")
    void validatePayment_WhenNotMultipleOfThousand_ThrowsException() {

        // given
        int invalidPayment = 2500;

        // when
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputManager.validatePayment(invalidPayment)
        );

        // then
        assertEquals(Messages.NonMultipleOfThousandException, thrown.getMessage());
    }
}
