package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.LottoRankResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoResultTest {
    LottoRankResult result;
    Lotto winningLottoNumbers;
    int bonusNumber;
    WinningLotto winningLotto;

    @BeforeEach
    void setTest() {
        result = new LottoRankResult();
        winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    @DisplayName("당첨되지 않은 로또가 주어지면 당첨되지 않은 로또의 개수만 증가해야 한다.")
    @Test
    void testWinningLottoResultByBuyerLotto() {
        //given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(1, 10, 11, 12, 13, 14)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))
        ));

        //when
        countWinningResult(lottos);
        int nonePlaceCount = result.getCountByLottoRank(LottoRank.NONE);

        //then
        assertThat(nonePlaceCount).isEqualTo(3);
    }

    @DisplayName("당첨된 로또가 한 개 주어지면 해당 등수 로또의 개수가 1증가해야 한다.")
    @Test
    void testWinningLottoResultByOnlyOneBuyerLotto() {
        //given
        Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));    // 1등

        //when
        result.countWinningResult(winningLotto, buyerLotto);
        int firstPlaceCount = result.getCountByLottoRank(LottoRank.FIRST);

        //then
        assertThat(firstPlaceCount).isEqualTo(1);
    }

    @DisplayName("당첨된 로또가 여러 개 주어지면 해당 등수 로또들의 개수가 1증가해야 한다.")
    @Test
    void testWinningLottoResultByOneMoreBuyerLotto() {
        //given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 13, 14, 15)),    // 5등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),       // 3등
                new Lotto(List.of(4, 5, 6, 8, 9, 10))       // 5등
        ));

        //when
        countWinningResult(lottos);
        List<Integer> counts = result.getCounts();

        //then
        List<Integer> target = List.of(0, 2, 0, 1, 1, 0);
        assertThat(counts).isEqualTo(target);
    }

    private void countWinningResult(Lottos lottos) {
        IntStream.range(0, lottos.size())
                .forEach(i -> result.countWinningResult(winningLotto, lottos.findLottoByIndex(i)));
    }
}
