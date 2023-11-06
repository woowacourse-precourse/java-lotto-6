package lotto.domain;

import static common.ErrorCode.BONUS_NUMBER_ALREADY_REGISTERED;
import static common.ErrorCode.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;
import static common.ErrorCode.WINNING_NUMBERS_DUPLICATED;
import static common.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 검증")
class WinningNumbersTest {

    @Test
    void 당첨_번호_6개_미만_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 당첨_번호_6개_초과_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 중복된_당첨_번호_에외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    void 당첨_번호_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers result = new WinningNumbers(numbers);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 보너스_번호가_등록된_상태에서_등록_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        WinningNumber winningNumber = new WinningNumber(7);
        winningNumbers.addBonus(winningNumber);

        // when
        // then
        assertThatThrownBy(() -> winningNumbers.addBonus(winningNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(BONUS_NUMBER_ALREADY_REGISTERED.getMessage());
    }

    @Test
    void 당첨_번호와_중복되는_보너스_번호_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        WinningNumber winningNumber = new WinningNumber(1);

        // when
        // then
        assertThatThrownBy(() -> winningNumbers.addBonus(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage());
    }
}
