package lotto.model;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.dto.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("map을 받아 로또 결과가 생성된다.")
    @Test
    void from() {
        // given
        Map<LottoRanking, Integer> expected = createMap(0, 0, 0, 0, 0);

        // when
        LottoResult result = LottoResult.createLottoResult(expected);

        // then
        assertThat(result).hasFieldOrPropertyWithValue("lottoResults", expected);
    }

    @DisplayName("당첨 순위를 입력받으면 횟수가 증가한다.")
    @Test
    void addLottoResult() {
        // given
        Map<LottoRanking, Integer> expected = createMap(0, 0, 0, 0, 0);
        LottoResult lottoResult = LottoResult.createLottoResult(expected);
        expected.put(FIRST, expected.get(FIRST) + 1);

        // when
        lottoResult.addLottoResult(FIRST);

        // then
        assertThat(lottoResult).hasFieldOrPropertyWithValue("lottoResults", expected);
    }

    @DisplayName("당첨 통계를 반환한다.")
    @Test
    void getWinnerStatistics() {
        // given
        Map<LottoRanking, Integer> given = createMap(0, 0, 0, 0, 0);
        LottoResult lottoResult = LottoResult.createLottoResult(given);
        WinningStatistics expected = new WinningStatistics(given);

        // when
        WinningStatistics result = lottoResult.getWinnerStatistics();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨 통계를 바탕으로 상금의 합을 계산한다.")
    @Test
    void calculatePrizeSum() {
        // given
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = 4;
        int fifth = 5;
        LottoResult lottoResult = LottoResult.createLottoResult(createMap(first, second, third, fourth, fifth));
        long expected = FIRST.getPrize() * first + SECOND.getPrize() * second + THIRD.getPrize() * third
                + FOURTH.getPrize() * fourth + FIFTH.getPrize() * fifth;
        // when
        long result = lottoResult.calculateWinningPrizeSum();

        // then
        assertThat(result).isEqualTo(expected);
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
