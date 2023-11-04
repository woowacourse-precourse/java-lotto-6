package lotto.controller;

import lotto.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller();

    @DisplayName("정수가 아닌 값 입력 시 IllegalArgumentException 발생 확인")
    @Test
    void amountFormatValidation() {
        String[] inputAmounts = {"천원", "1000원", "test"};

        for (String amount : inputAmounts) {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                controller.amountValidationProcess(amount);
            });
            assertEquals(exception.getMessage(), ErrorCode.AMOUNT_FORMAT.getMessage());
        }

    }

    @DisplayName("1000원 미만의 값 입력 시 IllegalArgumentException 발생 확인")
    @Test
    void amountInvalidValidation() {
        String[] inputAmounts = {"-2000", "300", "900"};

        for (String amount : inputAmounts) {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                controller.amountValidationProcess(amount);
            });
            assertEquals(exception.getMessage(), ErrorCode.AMOUNT_INVALID.getMessage());
        }

    }

    @DisplayName("1000원 단위가 아닌 값 입력 시 IllegalArgumentException 발생 확인")
    @Test
    void amountUnitValidation() {
        String[] inputAmounts = {"10400", "50020", "12345"};

        for (String amount : inputAmounts) {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                controller.amountValidationProcess(amount);
            });
            assertEquals(exception.getMessage(), ErrorCode.AMOUNT_UNIT.getMessage());
        }

    }



}