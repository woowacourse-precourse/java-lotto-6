package lotto.domain.lottoresult;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("일치 결과에 따라 맞는 LottoResult 를 반환 한다")
    @Test
    void lottoResultTest_1() {
        LottoResult result_First = LottoResult.getResult(6, false);
        LottoResult result_Second = LottoResult.getResult(5, true);
        LottoResult result_Third = LottoResult.getResult(5, false);
        LottoResult result_Fourth_1 = LottoResult.getResult(4, true);
        LottoResult result_Fourth_2 = LottoResult.getResult(4, false);
        LottoResult result_Fifth_1 = LottoResult.getResult(3, true);
        LottoResult result_Fifth_2 = LottoResult.getResult(3, false);

        assertThat(result_First).isEqualTo(LottoResult.FIRST);
        assertThat(result_Second).isEqualTo(LottoResult.SECOND);
        assertThat(result_Third).isEqualTo(LottoResult.THIRD);
        assertThat(result_Fourth_1).isEqualTo(LottoResult.FOURTH);
        assertThat(result_Fourth_2).isEqualTo(LottoResult.FOURTH);
        assertThat(result_Fifth_1).isEqualTo(LottoResult.FIFTH);
        assertThat(result_Fifth_2).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.getSizeOfLottoResult()).isEqualTo(5);
        assertThat(LottoResult.getSomeLottoResult(0)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.getSomeLottoResult(1)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.getSomeLottoResult(2)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("로또 결과 저장소를 초기화 하기 알맞은 Map 을 반환한다.")
    @Test
    void checkLottoResultMakeCorrectInitialResultsRepository() {
        Map<LottoResult, Integer> initialLottoResultsRepository = LottoResult.getInitialLottoResultsRepository();

        assertThat(initialLottoResultsRepository.get(LottoResult.NONE)).isEqualTo(0);
        assertThat(initialLottoResultsRepository.get(LottoResult.FIFTH)).isEqualTo(0);
        assertThat(initialLottoResultsRepository.get(LottoResult.FOURTH)).isEqualTo(0);
        assertThat(initialLottoResultsRepository.get(LottoResult.THIRD)).isEqualTo(0);
        assertThat(initialLottoResultsRepository.get(LottoResult.SECOND)).isEqualTo(0);
        assertThat(initialLottoResultsRepository.get(LottoResult.FIRST)).isEqualTo(0);
    }
}