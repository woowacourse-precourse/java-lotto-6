package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void generateLottoResult() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 14, 15, 18)));  // 5등
        lottos.add(new Lotto(List.of(21, 22, 23, 34, 35, 36)));  // 등수없음
        lottos.add(new Lotto(List.of(21, 22, 23, 34, 45, 11))); // 등수없음
        lottos.add(new Lotto(List.of(13, 12, 33, 18, 39, 10))); // 등수없음

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 11);

        lottoResult = new LottoResult(lottos, winningLotto);
    }


    @DisplayName("로또의 결과를 판단하는 테스트")
    @Test
    void 결과_판단_테스트() {
        LinkedHashMap<LottoRank, Integer> expectLottoResult = new LinkedHashMap<>();
        expectLottoResult.put(LottoRank.FIRST, 0);
        expectLottoResult.put(LottoRank.SECOND, 0);
        expectLottoResult.put(LottoRank.THIRD, 0);
        expectLottoResult.put(LottoRank.FOURTH, 0);
        expectLottoResult.put(LottoRank.FIFTH, 1);
        expectLottoResult.put(LottoRank.NO_RNAK, 3);

        lottoResult.judgeResult();

        assertThat(lottoResult.getLottoResult()).isEqualTo(expectLottoResult);
    }

    @DisplayName("로또 당첨 수익률을 계산하는 테스트")
    @Test
    void 수익률_계산_테스트() {
        lottoResult.judgeResult();
        int purchaseAmount = 8000;

        Double totalReturn = lottoResult.getTotalReturn(purchaseAmount);

        assertThat(totalReturn).isEqualTo(62.5);
    }
}
