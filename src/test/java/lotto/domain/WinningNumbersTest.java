package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import lotto.constant.ErrorMessage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersTest {

    @Test
    @DisplayName("유효한 로또 번호와 보너스 번호로 WinningNumbers 객체 생성")
    public void testValidWinningNumbersCreation() {
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(drawnNumbers, bonusNumber);

        Assertions.assertAll(() -> {
            assertThat(winningNumbers.drawnNumbers()).isEqualTo(drawnNumbers);
            assertThat(winningNumbers.bonusNumber()).isEqualTo(bonusNumber);
        });
    }

    @Test
    @DisplayName("보너스 번호 범위가 잘못된 경우 예외 발생")
    public void testWinningNumbersWithInvalidBonusNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new WinningNumbers(numbers, 50))
            .withMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 중복되는 경우 예외 발생")
    public void testLottoWithDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new WinningNumbers(numbers, 6))
            .withMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
    }
}
