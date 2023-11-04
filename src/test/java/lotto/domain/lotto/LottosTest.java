package lotto.domain.lotto;

import lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또의 모든 순위가 Enum에 정의한 순서대로 Key에 저장되어 있다.")
    public void lottoRanksKey() {
        // given
        Lottos lottos = getLottos();
        LottoResult lottoResult = getLottoResult();
        // when
        Map<LottoRank, Long> lottoRankMap = lottos.getLottoRankCountMap(lottoResult);
        // then
        Set<LottoRank> lottoRanks = lottoRankMap.keySet();
        assertThat(lottoRanks).hasSize(LottoRank.values().length)
                .containsExactly(
                        LottoRank.NO_RANK,
                        LottoRank.FIFTH,
                        LottoRank.FOURTH,
                        LottoRank.THIRD,
                        LottoRank.SECOND,
                        LottoRank.FIRST
                );
    }

    @Test
    @DisplayName("로또 순위에 해당하는 로또가 몇개있는지 Value에 저장되어 있다.")
    public void countLottoRanks() {
        // given
        Lottos lottos = getLottos();
        LottoResult lottoResult = getLottoResult();
        // when
        Map<LottoRank, Long> lottoRankMap = lottos.getLottoRankCountMap(lottoResult);
        // then
        Long secondCount = lottoRankMap.get(LottoRank.SECOND);
        Long thirdCount = lottoRankMap.get(LottoRank.THIRD);

        assertThat(secondCount).isEqualTo(1);
        assertThat(thirdCount).isEqualTo(2);
    }

    private Lottos getLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 30));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));
        return lottos;
    }

    private LottoResult getLottoResult() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        return new LottoResult(winningLotto, bonus);
    }
}