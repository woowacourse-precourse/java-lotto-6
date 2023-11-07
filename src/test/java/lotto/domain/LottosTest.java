package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottosTest {

    @Test
    void 로또를_당첨_번호와_보너스_번호로_등수_리스트로_변환에_성공한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

        // when
        List<Rank> ranks = lottos.convertToRank(winningNumbers, bonusNumber);

        // then
        assertThat(ranks)
                .hasSize(3)
                .hasOnlyElementsOfTypes(Rank.class);

    }

}
