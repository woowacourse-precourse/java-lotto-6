package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @DisplayName("로또 당첨 내역 개수 세기")
    @Test
    void getLottoResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        HashMap<WinningCriteria, Integer> result = new HashMap<>();
        result.put(WinningCriteria.FIRST, 1);
        result.put(WinningCriteria.SECOND, 1);
        result.put(WinningCriteria.THIRD, 1);
        result.put(WinningCriteria.FOURTH, 1);
        result.put(WinningCriteria.FIFTH, 1);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(lottoResult.getResult()).isEqualTo(result);
    }

    @DisplayName("총 수익률 계산하기")
    @Test
    void getRateOfReturn() {
        int amount = 6000;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(11, 21, 13, 14, 15, 16)));
        lottos.add(new Lotto(List.of(12, 22, 32, 42, 25, 27)));
        lottos.add(new Lotto(List.of(13, 32, 33, 34, 35, 38)));
        lottos.add(new Lotto(List.of(11, 22, 33, 34, 38, 39)));
        lottos.add(new Lotto(List.of(11, 22, 33, 34, 38, 39)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 9, 10)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(lottoResult.calculateRateOfReturn(amount)).isCloseTo(833.3, offset(0.05d));
    }
}
