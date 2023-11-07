package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개이면 로또 생성에 성공한다")
    @Test
    void 로또_번호의_개수가_중복되지_않고_개수가_6개이면_로또_생성에_성공한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    void 당첨_번호와_보너스_번호로_모두_일치하면_1등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

        // when
        Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 당첨_번호가_5개_일치하고_보너스_번호가_일치하면_2등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 8));
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);

        // when
        Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨_번호가_5개_일치하고_보너스_번호가_일치하지_않으면_3등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 8));
        BonusNumber bonusNumber = new BonusNumber(9, winningNumbers);

        // when
        Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 당첨_번호가_4개_일치하면_4등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 11, 10));
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);

        // when
        Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 당첨_번호가_3개_일치하면_5등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 12, 11, 10));
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);

        // when
        Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

}
