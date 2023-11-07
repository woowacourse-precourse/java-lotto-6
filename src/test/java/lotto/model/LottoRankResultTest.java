package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;
import lotto.ApplicationConfig;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.rank.LottoRank;
import lotto.model.rank.LottoRankResult;
import lotto.model.rank.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankResultTest {
    ApplicationConfig applicationConfig;
    LottoRankResult result;
    Lotto winningLottoNumbers;
    int bonusNumber;
    WinningLotto winningLotto;

    @BeforeEach
    void setTest() {
        applicationConfig = new ApplicationConfig();
        result = applicationConfig.lottoRankResult();
        winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    @DisplayName("당첨되지 않은 로또가 주어지면 당첨되지 않은 로또의 개수만 증가해야 한다.")
    @Test
    void testLottoRankResultByBuyerLotto() {
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
    void testLottoRankResultByOnlyOneBuyerLotto() {
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
    void testLottoRankResultByOneMoreBuyerLotto() {
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

    @DisplayName("당첨된 로또의 등수별 상금을 계산하여 총 수익률을 반환해야 한다.")
    @Test
    void testTotalReturnByLottoPrize() {
        //given
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 13, 14, 15)),    // 5등
                new Lotto(List.of(1, 2, 10, 15, 16, 17)),
                new Lotto(List.of(1, 2, 13, 20, 25, 28)),
                new Lotto(List.of(4, 5, 16, 28, 29, 30)),
                new Lotto(List.of(4, 5, 16, 18, 19, 30)),
                new Lotto(List.of(4, 5, 16, 38, 39, 40)),
                new Lotto(List.of(4, 5, 16, 28, 29, 40)),
                new Lotto(List.of(4, 5, 16, 28, 29, 45))
        ));

        //when
        countWinningResult(lottos);
        BigDecimal totalReturn = result.getTotalReturn(lottos.size());

        //then
        assertThat(decimalFormat.format(totalReturn)).isEqualTo("62.5");
    }

    private void countWinningResult(Lottos lottos) {
        IntStream.range(0, lottos.size())
                .forEach(i -> result.countWinningResult(winningLotto, lottos.findLottoByIndex(i)));
    }
}
