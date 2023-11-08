package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberExceptionTest {

    @DisplayName("보너스 번호 입력 시 숫자 이외의 문자를 입력하면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByNotNumber() {
        assertThatThrownBy(() -> InputValidator.checkBonusNumberInput("j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 1~45 범위 밖의 숫자를 입력하면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> InputValidator.checkBonusNumberInput("77"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 아무것도 입력하지 않으면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByNoInput() {
        assertThatThrownBy(() -> InputValidator.checkBonusNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    public void inputBonusNumberByDuplicateNumberWithJackpotNumber() {
        assertThatThrownBy(() -> InputValidator.checkDuplicateNumberInBonusNumbers(List.of(1, 2, 3, 4, 5, 6), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
