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

    // 당첨 번호 입력 에러 테스트
    @DisplayName("validateWinningNumberInput 메서드 테스트: null 입력 시 Exception 발생")
    @Test
    void validateWinningNumberInput_null_숫자_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호를 입력해주세요.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 빈값 입력 시 Exception 발생")
    @Test
    void validateWinningNumberInput_빈값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호를 입력해주세요.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 쉼표(,)로 구분되지 않은 경우 Exception 발생")
    @Test
    void validateWinningNumberInput_쉼표가_아닌값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)로 구분해주세요.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 당첨 번호가 6개가 아닌 경우 Exception 발생")
    @Test
    void validateWinningNumberInput_6자리가_아닌값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 당첨 번호가 중복된 경우 Exception 발생")
    @Test
    void validateWinningNumberInput_중복된값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 당첨 번호가 숫자가 아닌 경우 Exception 발생")
    @Test
    void validateWinningNumberInput_숫자가_아닌값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput("1,2,c,3,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @DisplayName("validateWinningNumberInput 메서드 테스트: 당첨 번호가 1~45 범위를 벗어난 경우 Exception 발생")
    @Test
    void validateWinningNumberInput_범위를_벗어난_값_입력시() {
        assertThatThrownBy(() -> UserHandler.validateWinningNumberInput("1,43,48,49,50,51"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45까지의 숫자입니다.");
    }
}
