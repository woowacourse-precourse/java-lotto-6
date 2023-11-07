package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        final Set<LottoNumber> winningNumberSet = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
        winningNumbers = new LottoNumbers(winningNumberSet);
        bonusNumber = new LottoNumber(7);
        winningNumber = new WinningNumber(winningNumbers, bonusNumber);
    }

    @Test
    void 보너스_번호가_당첨번호_중_하나와_중복된_경우_예외_발생() {
        // given
        final LottoNumber duplicatedBonusNumber = new LottoNumber(1);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_로또_번호가_일치하는_수_계산() {
        // given
        final Lotto lotto = new Lotto(winningNumbers);

        // when
        final int matchCount = winningNumber.countMatch(lotto);

        // then
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 로또에_보너스번호가_포함되어_있는지_확인() {
        // given
        final Lotto lottoWithBonus = new Lotto(new LottoNumbers(Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), bonusNumber
        )));

        // when
        final boolean bonusNumberMatch = winningNumber.checkBonusNumber(lottoWithBonus);

        // then
        assertThat(bonusNumberMatch).isTrue();
    }
}

