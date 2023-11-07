package lotto.validator;

import static lotto.exception.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @Test
    void 당첨번호_리스트의_크기가_6이_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4), any(Integer.class)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
    }

    @Test
    void 당첨번호_리스트에_중복된_숫자가_있는_경우_예외() {
        int sameNumber = 10;

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, sameNumber, sameNumber), any(Integer.class)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}
