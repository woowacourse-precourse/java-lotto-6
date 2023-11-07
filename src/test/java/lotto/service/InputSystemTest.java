package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputSystemTest {

    @DisplayName("숫자가 아닌 입력이 들어왔을 때 예외처리")
    @Test
    void checkIsDigit() {
        //given
        InputSystem inputSystem = new InputSystem();
        String inputNum = "100j";
        //when & then
        assertThatThrownBy(() -> inputSystem.checkIsDigit(inputNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}