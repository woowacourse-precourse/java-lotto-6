package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import lotto.global.ErrorMessage;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 생성_정상_케이스() {
        //given
        int bonusNumber = 15;
        Set<Integer> originalWinningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        //when
        WinningNumbers winningNumbers = new WinningNumbers(originalWinningNumbers, bonusNumber);

        //then
        assertThat(winningNumbers.getOriginalWinningNumbers()).isEqualTo(originalWinningNumbers);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }
    @Test
    void 당첨_번호가_6개가_아닌_경우() {
        //given
        int bonusNumber = 15;
        Set<Integer> originalWinningNumbers = Set.of(1, 2, 3, 4, 5, 6, 7);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
    }
    @Test
    void 보너스_번호가_이미_당첨_번호에_있는_경우() {
        //given
        int bonusNumber = 15;
        Set<Integer> originalWinningNumbers = Set.of(1, 2, 15, 4, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_CONTAINS_BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
    }
    @Test
    void 당첨_번호중_1_미만_숫자가_있는_경우() {
        //given
        int bonusNumber = 15;
        Set<Integer> originalWinningNumbers = Set.of(1, 0, 3, 4, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }

    @Test
    void 당첨_번호중_45_초과_숫자가_있는_경우() {
        //given
        int bonusNumber = 15;
        Set<Integer> originalWinningNumbers = Set.of(1, 3, 47, 4, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }

    @Test
    void 보너스_번호가_1_미만_숫자인_경우() {
        //given
        int bonusNumber = 0;
        Set<Integer> originalWinningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }
    @Test
    void 보너스_번호가_45_초과_숫자인_경우() {
        //given
        int bonusNumber = 47;
        Set<Integer> originalWinningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> new WinningNumbers(originalWinningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }
}
