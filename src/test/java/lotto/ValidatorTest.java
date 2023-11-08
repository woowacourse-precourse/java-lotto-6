package lotto;

import lotto.exception.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void isValidWinningNumbersSize() {
        assertThatThrownBy(() -> Validator.isValidWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 중복되지 않는 숫자 6개가 아니면 예외가 발생한다.")
    @Test
    void isValidWinningNumbersRangeAndDuplicated() {
        assertThatThrownBy(() -> Validator.isValidWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void isValidAmount() {
        assertThatThrownBy(() -> Validator.isValidAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.PURCHASE_AMOUNT_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void isValidBonusNumberRange() {
        assertThatThrownBy(() -> Validator.isValidBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.BONUS_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void isValidBonusNumberDuplicated() {
        assertThatThrownBy(() -> Validator.isValidBonusNumber(6, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.BONUS_NUMBER_ERROR_MESSAGE);
    }
}
