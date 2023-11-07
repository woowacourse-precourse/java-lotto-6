package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoNumberTest {

    @Test
    void 로또_번호가_숫자가_아니면_예외가_발생한다() {
        // given
        String number = "일";

        // when & then
        assertThatThrownBy(() -> LottoNumber.createWith(number))
                .isInstanceOf(CanNotConvertToNumberException.class);
    }

    @Test
    void 로또_번호가_1부터_45까지의_숫자가_아니라면_예외가_발생한다() {
        // given
        String number = "46";

        // when & then
        assertThatThrownBy(() -> LottoNumber.createWith(number))
                .isInstanceOf(InvalidNumberException.class);
    }
}
