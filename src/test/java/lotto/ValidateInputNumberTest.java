package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputNumberTest {

    ValidateInputNumber validateInputNumber = new ValidateInputNumber();

    @Test
    void inputNumberTest() {
        int value = validateInputNumber.inputNumber("1000");
        assertEquals(value, 1000);
    }

    @Test
    void inputNumberErrorTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            int value = validateInputNumber.inputNumber("1000kj");
        });
    }

}