package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningCombinationTest {

    @Test
    void 보너스_번호는_당첨번호와_중복된_상태로_생성할_수_없다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(6);

        assertThatThrownBy(() -> WinningCombination.of(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호는_당첨번호와_중복되지_않은_상태로_생성할_수_있다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);

        assertDoesNotThrow(() -> WinningCombination.of(winningLotto, bonusNumber));
    }

    @Test
    void 우승조합에서_당첨번호를_가지고_있으면_참을_반환한다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);
        LottoNumber lottoNumber = LottoNumber.from(6);

        boolean expected = winningCombination.hasLottoNumber(lottoNumber);

        assertThat(expected).isTrue();
    }

    @Test
    void 우승조합에서_당첨번호를_가지고_있지_않으면_거짓을_반환한다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);
        LottoNumber lottoNumber = LottoNumber.from(8);

        boolean expected = winningCombination.hasLottoNumber(lottoNumber);

        assertThat(expected).isFalse();
    }

    @Test
    void 우승조합에서_보너스번호를_가지고_있으면_참을_반환한다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);
        LottoNumber lottoNumber = LottoNumber.from(7);

        boolean expected = winningCombination.hasBonusNumber(lottoNumber);

        assertThat(expected).isTrue();
    }

    @Test
    void 우승조합에서_보너스번호를_가지고_있지_않으면_거짓을_반환한다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);
        LottoNumber lottoNumber = LottoNumber.from(8);

        boolean expected = winningCombination.hasBonusNumber(lottoNumber);

        assertThat(expected).isFalse();
    }
}
