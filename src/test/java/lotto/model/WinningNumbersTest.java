package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExistDuplicatedNumberException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class WinningNumbersTest {

    @Test
    void 당첨_번호와_보너스_번호_사이에_중복된_번호가_존재한다면_예외가_발생한다() {
        // given
        WinningNumber winningNumber = WinningNumber.createWith("1,2,3,4,5,6,");
        LottoNumber bonusNumber = LottoNumber.createWith("6");

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(ExistDuplicatedNumberException.class);
    }
}
