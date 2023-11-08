package Validate;

import lotto.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateTest {
    @Test
    @DisplayName("유효하지 않은 형식의 구입금액을 입력시 예외 발생")
    void cashForm_NonNumerInput() {
        assertThatThrownBy(() -> Validate.CashForm("abc"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("1000의 배수가 아닌 구입금액을 입력한 경우 예외 발생")
    void cashForm_InvalidAmountInput() {
        assertThatThrownBy(() -> Validate.CashForm("1500"))
                .isInstanceOf(NoSuchElementException.class);
    }

}
