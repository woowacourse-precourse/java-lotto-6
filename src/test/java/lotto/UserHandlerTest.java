package lotto;

import lotto.handler.UserHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserHandlerTest {
    @DisplayName("validateUserInput 메서드 테스트: null 입력 시 Exception 발생")
    @Test
    void validateUserInput_null값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateUserInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액을 입력해주세요.");
    }
}
