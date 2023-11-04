package lotto.controller;

import lotto.constants.ErrorCode;
import lotto.utils.ParseUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller();
    ParseUtils parseUtils = new ParseUtils();

    @DisplayName("정수가 아닌 값 입력 시 null이 반환되는 지 확인")
    @Test
    void amountFormatValidation() {
        String[] inputAmounts = {"천원", "1000원", "test"};

        for (String amount : inputAmounts) {
            assertEquals(controller.amountValidationProcess(amount), null);
        }

    }

    @DisplayName("1000원 미만의 값 입력 시 null이 반환되는 지 확인")
    @Test
    void amountInvalidValidation() {
        String[] inputAmounts = {"-2000", "300", "900"};

        for (String amount : inputAmounts) {
            assertEquals(controller.amountValidationProcess(amount), null);
        }

    }

    @DisplayName("1000원 단위가 아닌 값 입력 시 null이 반환되는 지 확인")
    @Test
    void amountUnitValidation() {
        String[] inputAmounts = {"10400", "50020", "12345"};

        for (String amount : inputAmounts) {
            assertEquals(controller.amountValidationProcess(amount), null);
        }

    }

    @DisplayName("1000원 이상의 1000원 단위 값 입력 시 입력한 값이 int형으로 반환되는 지 확인")
    @Test
    void getAmount() {
        String[] inputAmounts = {"1000", "2000", "1000000"};

        for (String amount : inputAmounts) {
            assertEquals(controller.amountValidationProcess(amount), parseUtils.parseStringToInt(amount));
        }
    }



}