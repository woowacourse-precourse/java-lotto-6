package lotto.model;

import static lotto.model.LottoRank.FOUR_MATCH;
import static lotto.model.LottoRank.LESS_THREE_MATCH;
import static lotto.model.LottoRank.THREE_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("로또들의 당첨 등수에 맞춰 결과를 생성한다")
    @Test
    void createLottoResult() {
        final LottoResult lottoResult = new LottoResult(
            List.of(THREE_MATCH, FOUR_MATCH, LESS_THREE_MATCH));

        final List<String> outputStrings = lottoResult.toOutputStrings();
        assertThat(outputStrings).contains("3개 일치 (5,000원) - 1개");
        assertThat(outputStrings).contains("4개 일치 (50,000원) - 1개");
        assertThat(outputStrings).contains("5개 일치 (1,500,000원) - 0개");
        assertThat(outputStrings).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        assertThat(outputStrings).contains("6개 일치 (2,000,000,000원) - 0개");
    }

    @DisplayName("수익금과 로또 구매 금액을 이용해 수익률을 계산한다")
    @Test
    void calculateEarningRate() {
        final LottoResult lottoResult = new LottoResult(List.of(THREE_MATCH, LESS_THREE_MATCH));

        final double earningsRate = lottoResult.getEarningsRate();

        assertThat(String.format("%.1f", earningsRate)).isEqualTo("250.0");
    }

}