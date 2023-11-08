package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.WinnerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @DisplayName("등외 ~ 4등까지 값 검증 테스트")
    @Test
    void validateCalculateLottoResultsByFourthPlaceFromOutOfBound() {

        List<Lotto> lottos = makeLottosByFourthPlaceFromOutOfBoundNumber();
        WinnerNumbers winnerNumbers = new WinnerNumbers(Arrays.asList(1,2,3,4,5,6), 7);
        LottoStatistics lottoStatistics = new LottoStatistics();

        Map<LottoResult, Integer> result = lottoStatistics.calculateLottoResults(lottos, winnerNumbers);

        assertThat(result.get(LottoResult.OUT_OF_BOUND_NO_MATCH)).isEqualTo(1);
        assertThat(result.get(LottoResult.OUT_OF_BOUND_ONE_MATCH)).isEqualTo(1);
        assertThat(result.get(LottoResult.OUT_OF_BOUND_TWO_MATCH)).isEqualTo(1);
        assertThat(result.get(LottoResult.FIFTH_PLACE)).isEqualTo(1);
        assertThat(result.get(LottoResult.FOURTH_PLACE)).isEqualTo(3);
    }

    @DisplayName("3등 ~ 1등까지 값 검증 테스트")
    @Test
    void validateCalculateLottoResultsByThirdPlaceFromFirstPlace() {

        List<Lotto> lottos = makeLottosByThirdPlaceFromFirstNumber();
        WinnerNumbers winnerNumbers = new WinnerNumbers(Arrays.asList(1,2,3,4,5,6), 7);
        LottoStatistics lottoStatistics = new LottoStatistics();

        Map<LottoResult, Integer> result = lottoStatistics.calculateLottoResults(lottos, winnerNumbers);

        assertThat(result.get(LottoResult.THIRD_PLACE)).isEqualTo(2);
        assertThat(result.get(LottoResult.SECOND_PLACE)).isEqualTo(2);
        assertThat(result.get(LottoResult.FIRST_PLACE)).isEqualTo(2);
    }

    private List<Lotto> makeLottosByFourthPlaceFromOutOfBoundNumber() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto( Arrays.asList(8,9,10,11,12,13)));
        lottos.add(new Lotto( Arrays.asList(1,9,10,11,12,13)));
        lottos.add(new Lotto( Arrays.asList(1,2,10,11,12,13)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,11,12,13)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,12,13)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,14,15)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,16,17)));

        return lottos;
    }

    private List<Lotto> makeLottosByThirdPlaceFromFirstNumber() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto( Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,5,7)));
        lottos.add(new Lotto( Arrays.asList(2,3,4,5,6,7)));
        lottos.add(new Lotto( Arrays.asList(1,2,3,4,5,8)));
        lottos.add(new Lotto( Arrays.asList(2,3,4,5,6,9)));

        return lottos;
    }
}
