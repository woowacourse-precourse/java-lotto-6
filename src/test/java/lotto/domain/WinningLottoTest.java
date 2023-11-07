package lotto.domain;

import static lotto.exception.Exception.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.Exception.INVALID_NUMBER_RANGE;
import static lotto.exception.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 당첨번호가_1부터_45_범위에_벗어난_경우() {
        int outRangeNumber = 50;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 10, outRangeNumber), 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 당첨번호_리스트의_크기가_6이_아닌_경우_예외() {
        List<Integer> fourNumbers = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> new WinningLotto(fourNumbers, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
    }

    @Test
    void 당첨번호_리스트에_중복된_숫자가_있는_경우_예외() {
        int sameNumber = 10;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, sameNumber, sameNumber), 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    void 보너스번호가_1부터_45_범위에_벗어난_경우() {
        int outRangeNumbers = 50;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), outRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 보너스번호가_당첨_번호와_중복된_경우_예외() {
        int sameNumber = 20;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 10, sameNumber), sameNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
