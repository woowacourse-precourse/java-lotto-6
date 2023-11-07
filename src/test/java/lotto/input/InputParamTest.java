package lotto.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParamTest {
    InputParam inputParam = new InputParam();
    @DisplayName("정상적인 금액이 입력됬을 때 예외가 발생하면 안됨")
    @Test
    void errorCheckInputMoney() {
        String inputMoney="10000";
        inputParam.errorCheckInputMoney(inputMoney);

    }
@DisplayName("정상적인 번호가 입력됬을 때 예외가 발생하면 안됨")
    @Test
    void errorCheckInputNumber() {
        int[] inputNumbers={1, 6, 2,3, 4, 5};
        inputParam.errorCheckInputNumber(inputNumbers);
    }
}