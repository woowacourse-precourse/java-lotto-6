package lotto.input;

import org.junit.jupiter.api.Test;

class InputParamTest {
    InputParam inputParam = new InputParam();
    @Test
    void errorCheckInputMoney() {
        String inputMoney="10000";
        inputParam.errorCheckInputMoney(inputMoney);

    }

    @Test
    void errorCheckInputNumber() {
        int[] inputNumbers={1, 6, 2,3, 4, 5};
        inputParam.errorCheckInputNumber(inputNumbers);
    }
}