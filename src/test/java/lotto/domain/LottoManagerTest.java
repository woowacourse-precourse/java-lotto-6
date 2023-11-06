package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoManagerTest {

    private final static LottoManager manager = LottoManager.from(new LottoGenerator());

    @ParameterizedTest
    @CsvSource(value = {"8, 8", "4, 4", "1, 1", "10000, 10000"})
    void LottoManager는_구입개수를_받아_로또를_구매한다(int count, int result) {
        //when
        manager.buyAutoLottos(count);
        //then
        assertThat(manager.getAutoLottos().size()).isEqualTo(result);
    }

    @Test
    void totalMatchNumber는_등수별_당첨개수를_센다() {
        // given
        List<MatchNumber> matchs = List.of(
                MatchNumber.NOTHING,
                MatchNumber.FIFTH,
                MatchNumber.FIRST
        );
        // when
        List<Integer> result = manager.totalMatchNumber(matchs);
        // then
        assertThat(result.get(MatchNumber.FIFTH.getListIndex())).isEqualTo(1);
        assertThat(result.get(MatchNumber.FOURTH.getListIndex())).isEqualTo(0);
        assertThat(result.get(MatchNumber.THIRD.getListIndex())).isEqualTo(0);
        assertThat(result.get(MatchNumber.SECOND.getListIndex())).isEqualTo(0);
        assertThat(result.get(MatchNumber.FIRST.getListIndex())).isEqualTo(1);
    }
}