package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DrawingMachineTest {

    @Test
    void 당첨로또와_일반로또비교() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos =
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                        , new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                        , new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)));
        Lottos purchasedLottos = new Lottos(lottos);
        DrawingMachine drawingMachine = new DrawingMachine(new Lotto(winningNumbers), new BonusNumber(6));
        //when
        DrawResult result = drawingMachine.compare(purchasedLottos);
        //then
        Map<LottoRank, Integer> rankMap = result.getRankMap();

        assertThat(rankMap.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(rankMap.get(LottoRank.FIFTH)).isEqualTo(1);
    }
}
