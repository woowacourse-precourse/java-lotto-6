package lotto.view.output;

import lotto.view.DisplayTestSupport;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultDisplayViewTest extends DisplayTestSupport {

    private LottoResultOutputView lottoResultOutputView = new LottoResultOutputView();

    @Test
    @DisplayName("당첨 통계라는 문자열을 출력할 수 있다.")
    public void printWinningStatisticsStartMessage() {
        // given
        String result = "당첨 통계";
        // when
        lottoResultOutputView.printWinningStatisticsStartMessage();
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("--- dash라인을 출력할 수 있다.")
    public void printDashLine() {
        // given
        String result = "---";
        // when
        lottoResultOutputView.printDashLine();
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("당첨된 로또 통계를 전부 출력할 수 있다.")
    public void printLottoAllMatch() {
        // given
        String result = "3개 일치 (5,000원) - 2개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n";

        Lottos lottos = createLottos();
        LottoResult lottoResult = createLottoResult();
        Map<LottoRank, Long> lottoRankCountMap = lottos.getLottoRankCountMap(lottoResult);
        // when
        lottoResultOutputView.printLottoAllMatch(lottoRankCountMap);
        // then
        assertThat(result).isEqualTo(outputNotTrim());
    }

    @Test
    @DisplayName("총 수익률을 출력할 수 있다.")
    public void printTotalProfitRate() {
        // given
        long amount = 10000;
        double calculate = ((double) (5000 * 2) / amount) * 100.0;
        String result = String.format("총 수익률은 %.1f%%입니다.", calculate);

        Lottos lottos = createLottos();
        LottoResult lottoResult = createLottoResult();
        Map<LottoRank, Long> lottoRankCountMap = lottos.getLottoRankCountMap(lottoResult);
        // when
        lottoResultOutputView.printTotalProfitRate(amount, lottoRankCountMap);
        // then
        assertThat(result).isEqualTo(output());
    }

    private LottoResult createLottoResult() {
        return new LottoResult(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 45);
    }

    private Lottos createLottos() {
        Lottos lottos = new Lottos(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        return lottos;
    }
}