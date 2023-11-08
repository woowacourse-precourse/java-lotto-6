package lotto;

import lotto.domain.WinningNumbers;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersWithInvalidLength() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.IS_NOT_SIX_NUMBERS.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45까지의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumbersWithInvalidRange() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersWithDuplicateNumbers() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
    }
}