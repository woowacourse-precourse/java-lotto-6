package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.DuplicateNumbersException;
import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class WinningLottoTest {

    @Test
    void 보너스_번호가_로또_번호에_포함되어_있으면_예외가_발생한다() {
        // given
        Lotto lotto = Lotto.fromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(6);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(DuplicateNumbersException.class);
    }

    @Test
    void 해당_넘버가_보너스_번호를가지고있다면_참_반환한다() {
        // given
        Lotto lotto = Lotto.fromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // when
        boolean result = winningLotto.hasMatchingBonus(List.of(Number.from(7)));

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 해당_넘버가_보너스_번호를가지고있지_않다면_거짓_반환한다() {
        // given
        Lotto lotto = Lotto.fromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // when
        boolean result = winningLotto.hasMatchingBonus(List.of(Number.from(10)));

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 해당_로또와_몇개의_수가_일치하는지_개수를_반환한다() {
        // given
        Lotto lotto = Lotto.fromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto purchasedLotto = LottoFixture.create("1,2,3,4,5,6");

        // when
        int result = winningLotto.countMatchingNumbers(purchasedLotto.getLottoNumbers());

        // then
        assertThat(result).isEqualTo(6);
    }
}
