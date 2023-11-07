package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputControllerTest {
    @DisplayName("보너스 번호의 값이 46 이상이면 예외가 발생한다.")
    @Test
    void bonusInput() {
        String invalidInput = "47";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        assertThrows(NumberFormatException.class, () -> {
            InputController.bonusInput();
        });
    }
}
