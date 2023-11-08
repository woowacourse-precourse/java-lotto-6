package lotto.dto;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("당첨 통계를 출력 문구 형식으로 변환한다.")
    @Test
    void toStringTest() {
        // given
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = 4;
        int fifth = 5;
        WinningStatistics winningStatistics = new WinningStatistics(createMap(first, second, third, fourth, fifth));
        String expected = new DecimalFormat("#,##0").format(FIRST.getPrize());

        // when
        String result = winningStatistics.toString();

        // then
        assertThat(result).contains("개 일치, 보너스 볼 일치 ")
                .contains("개 일치 (")
                .contains(expected)
                .contains(String.valueOf(first));
    }

    private Map<LottoRanking, Integer> createMap(int first, int second, int third, int fourth, int fifth) {
        Map<LottoRanking, Integer> lottoResults = new HashMap<>();
        lottoResults.put(FIRST, first);
        lottoResults.put(SECOND, second);
        lottoResults.put(THIRD, third);
        lottoResults.put(FOURTH, fourth);
        lottoResults.put(FIFTH, fifth);
        return lottoResults;
    }
}
