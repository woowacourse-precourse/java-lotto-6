package lotto;

import lotto.handler.UserHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserHandlerTest {
    @DisplayName("validateUserInput 메서드 테스트: null 입력 시 Exception 발생")
    @Test
    void validateUserInput_null값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateUserInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액을 입력해주세요.");
    }

    @DisplayName("validateUserInput 메서드 테스트: 빈값 입력 시 Exception 발생")
    @Test
    void validateUserInput_빈값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateUserInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액을 입력해주세요.");
    }

    @DisplayName("validateUserInput 메서드 테스트: 0으로 시작하는 숫자 입력 시 Exception 발생")
    @Test
    void validateUserInput_0으로_시작하는_숫자_입력시() {
        assertThatThrownBy(() -> UserHandler.validateUserInput("0123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 0으로 시작하는 숫자를 입력하지 마세요.");
    }

    @DisplayName("validateUserInput 메서드 테스트: 1000단위가 아닌 값 입력 시 Exception 발생")
    @Test
    void validateUserInput_1000단위가_아닌_숫자_입력시() {
        assertThatThrownBy(() -> UserHandler.validateUserInput("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력해주세요.");
    }




}
