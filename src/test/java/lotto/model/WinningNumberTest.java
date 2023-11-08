package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class WinningNumberTest {

    @Test
    void 당첨_번호에_숫자가_아닌_값이_있는_경우_예외가_발생한다() {
        // given
        String winningNumber = "1,2,3,사,오,육";

        // when & then
        assertThatThrownBy(() -> WinningNumber.createWith(winningNumber))
                .isInstanceOf(CanNotConvertToNumberException.class);
    }

    @Test
    void 당첨_번호가_6자리가_아닌_경우_예외가_발생한다() {
        // given
        String winningNumber = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> WinningNumber.createWith(winningNumber))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    void 당첨_번호에_중복된_번호가_존재하는_경우_예외가_발생한다() {
        // given
        String winningNumber = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> WinningNumber.createWith(winningNumber))
                .isInstanceOf(ExistDuplicatedNumberException.class);
    }


}
