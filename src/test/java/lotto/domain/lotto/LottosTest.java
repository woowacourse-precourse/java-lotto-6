package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos getLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 30));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));
        return lottos;
    }

    @Test
    @DisplayName("로또 순위를 Key로 받을 수 있다.")
    public void lottoRanksKey() {
        // given
        Lottos lottos = getLottos();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        // when
        Map<LottoRank, Long> lottoRankMap = lottos.countLottoRanks(winningLotto, bonus);
        // then
        Set<LottoRank> lottoRanks = lottoRankMap.keySet();
        assertThat(lottoRanks).hasSize(2)
                .contains(LottoRank.SECOND, LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또 순위에 해당하는 로또가 몇개있는지 Value로 받을 수 있다.")
    public void countLottoRanks() {
        // given
        Lottos lottos = getLottos();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        // when
        Map<LottoRank, Long> lottoRankMap = lottos.countLottoRanks(winningLotto, bonus);
        // then
        Long secondCount = lottoRankMap.get(LottoRank.SECOND);
        Long thirdCount = lottoRankMap.get(LottoRank.THIRD);

        assertThat(secondCount).isEqualTo(1);
        assertThat(thirdCount).isEqualTo(2);
    }
}