package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class InputManagerTest {

    @DisplayName("복권 구입 금액을 입력 받는다.")
    @Test
    void getPurchaseAmount() {
        InputManager inputManager = new InputManager();
        assertThat(inputManager.getPurchaseAmount("8000")).isEqualTo(8000);
    }
}