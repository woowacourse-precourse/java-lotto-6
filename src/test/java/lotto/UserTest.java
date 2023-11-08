package lotto;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.MONEY_UNIT_MISMATCH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("돈이 양의 정수가 아니면 예외가 발생한다.")
    @Test
    void createUserByNegativeNumber() {
        assertThatThrownBy(() -> UserValidator.validateMoney("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TYPE_MISMATCH.message());
    }

    @DisplayName("돈의 단위가 올바르지 않으면 예외가 발생한다.")
    @Test
    void createUserByAnotherDigitNumber() {
        assertThatThrownBy(() -> UserValidator.validateMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_UNIT_MISMATCH.message());
    }
}
