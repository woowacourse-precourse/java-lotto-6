package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    Validator validator = new Validator();
    @DisplayName("금액이 0원이면 예외가 발생한다.")
    @Test
    void checkValidateAmountZero() {
        int invalidAmount = 0;
        assertThatThrownBy(() -> validator.validateAmountUnit(invalidAmount))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("금액의 단위가 1000원이 아니면 예외가 발생한다.")
    @Test
    void checkValidateAmountUnit() {
        int invalidAmount = 1;
        assertThatThrownBy(() -> validator.validateAmountUnit(invalidAmount))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("당첨 번호의 크기가 6이 아니면 예외가 발생한다.")
    @Test
    void checkValidateWinNumberLength() {
        String[] invalidWinNumber = {"1", "2", "3", "4"};
        assertThatThrownBy(() -> validator.validateWinNumberLength(invalidWinNumber))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("당첨 번호가 정수가 아니라면 예외가 발생한다.")
    @Test
    void checkValidateWinNumberInt() {
        String[] invalidWinNumber = {"J", "1", "2", "3", "4", "5"};
        assertThatThrownBy(() -> validator.validateWinNumberInt(invalidWinNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("당첨 번호에 중복된 수가 포함되면 예외가 발생한다.")
    @Test
    void checkValidateWinNumberDuplicate() {
        assertThatThrownBy(() -> validator.validateWinNumberDuplicate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
