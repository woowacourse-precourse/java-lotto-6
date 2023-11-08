package lotto.Util;

import lotto.LottoFactory.LottoChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    @DisplayName("당첨로또 입력시 잘못된 구분자를 사용한 경우 예외 발생")
    void winningLottoInput_InvalidDelimiter() {
        assertThatThrownBy(() -> Validate.WinningLottoInput("1|2 3,4*5a6&"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
