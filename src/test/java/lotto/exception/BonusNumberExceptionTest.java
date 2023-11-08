package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberExceptionTest {

    @DisplayName("보너스 숫자 입력 시 숫자 이외의 문자를 입력하면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByNotNumber() {
        assertThatThrownBy(() -> InputValidator.checkBonusNumberInput("j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 입력 시 1~45 범위 밖의 숫자를 입력하면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> InputValidator.checkBonusNumberInput("77"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
