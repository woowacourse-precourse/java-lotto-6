package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LottoResultStoreTest {
    LottoResultStore lottoResultStore = new LottoResultStore();

    @DisplayName("당첨 내역이 초기화되었는지 확인한다.")
    @Test
    void resetLottoResultStore() {
        lottoResultStore.resetLottoResultStore();
        Map<Integer, Integer> resultStore = lottoResultStore.getLottoResultStore();

        Assertions.assertThat(0).isEqualTo(resultStore.get(5_000));
        Assertions.assertThat(0).isEqualTo(resultStore.get(2_000_000_000));
    }

    @DisplayName("3개의 당첨번호가 일치했을 때 당첨 갯수를 확인한다.")
    @Test
    void checkMatchThreeWinningNumber() {
        lottoResultStore.resetLottoResultStore();
        lottoResultStore.checkLottoRank(3, 0);
        Map<Integer, Integer> resultStore = lottoResultStore.getLottoResultStore();

        Assertions.assertThat(1).isEqualTo(resultStore.get(5_000));
    }

    @DisplayName("5개의 당첨번호와 1개의 보너스번호가 일치했을 때 당첨 갯수를 확인한다.")
    @Test
    void checkMatchFiveWinningNumberOneBonusNumber() {
        lottoResultStore.resetLottoResultStore();
        lottoResultStore.checkLottoRank(5, 1);
        Map<Integer, Integer> resultStore = lottoResultStore.getLottoResultStore();

        Assertions.assertThat(1).isEqualTo(resultStore.get(30_000_000));
    }
}
