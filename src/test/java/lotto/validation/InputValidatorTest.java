package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("입력 금액이 부족하다면 에러")
    void 금액_부족() {
        String input = "900";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.moneyValidate(input);
        });
    }

    @Test
    @DisplayName("구매금액으로 정수이외의 값이 들어오면 에러")
    void 정수_이외_입력() {
        String input = "abc";

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input);
        });
    }

    @Test
    @DisplayName("구매금액이 1000원으로 나누어 떨어지지 않으면 에러")
    void 금액_에러() {
        String input = "1500";

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input);
        });
    }

    @Test
    @DisplayName("구매금액이 정수형 변수의 범위를 초과한다면 에러")
    void 오버플로우_에러() {
        String input = "987654321";

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input);
        });
    }

    @Test
    @DisplayName("당첨번호에 공백입력시 에러")
    void 당첨_공백() {
        String[] input = "1,2,,3,4,5".split(",", -1);

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input);
        });
    }

    @Test
    @DisplayName("당첨번호에 정수이외의 입력이 들어올 경우 에러")
    void 당첨번호_예외() {
        String[] input = {"1", "2", "3", "4", "5", "abc"};

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input);
        });
    }

    @Test
    @DisplayName("보너스 번호에 정수이외의 입력이 들어올 경우 에러")
    void 보너스번호_예외() {
        String input1 = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.bonusValidate(input1);
        });
    }
}