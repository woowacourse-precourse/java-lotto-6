package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PayAmountExceptionTest {

    @DisplayName("로또 구입 금액을 1,000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputPayAmountByMissUnit() {
        assertThatThrownBy(() -> InputValidator.checkLottoPayAmountInput("1280"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액 입력 시 숫자 이외의 문자를 입력하면 예외가 발생한다.")
    @Test
    void inputPayAmountByNotNumber() {
        assertThatThrownBy(() -> InputValidator.checkLottoPayAmountInput("128one"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액 입력 시 1,000원 미만을 입력하면 예외가 발생한다.")
    @Test
    void inputPayAmountByLittleAmount() {
        assertThatThrownBy(() -> InputValidator.checkLottoPayAmountInput("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액 입력 시 아무것도 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputPayAmountByNoInput() {
        assertThatThrownBy(() -> InputValidator.checkLottoPayAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
