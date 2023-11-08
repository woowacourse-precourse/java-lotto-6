package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoManagerTest {

    @ParameterizedTest
    @CsvSource(value = {"8, 8", "4, 4", "1, 1", "10000, 10000"})
    void buyAutoLottos는_구입개수를_받아_로또를_구매한다(int count, int result) {
        //given
        LottoManager manager = LottoManager.from(new LottoGenerator());
        //when
        manager.buyAutoLottos(count);
        //then
        assertThat(manager.getAutoLottos().getLottos().size()).isEqualTo(result);
    }

    @Test
    void judgeRankByLotto는_로또의_당첨등수를_판단한다() {
        // given
        LottoManager manager = LottoManager.from(new LottoGenerator());
        manager.createWinning(WinningLotto.createWinningLottos(List.of(1, 2, 3, 4, 5, 6)), Bonus.from(10));
        // when
        List<LottoRank> ranks = manager.judgeRankByLotto();
        // then
        assertThat(ranks.size()).isEqualTo(manager.getAutoLottos().getLottos().size());
    }

    @Test
    void totalCountPerRank는_등수별_당첨개수를_센다() {
        // given
        LottoManager manager = LottoManager.from(new LottoGenerator());
        List<LottoRank> matchs = List.of(LottoRank.NOTHING, LottoRank.FIFTH, LottoRank.FIRST);
        // when
        List<Integer> result = manager.totalCountPerRank(matchs);
        // then
        assertThat(result.get(LottoRank.FIFTH.getListIndex())).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.THIRD.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.SECOND.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.FIRST.getListIndex())).isEqualTo(1);
    }

}