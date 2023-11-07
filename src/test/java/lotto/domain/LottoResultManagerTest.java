package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.global.constant.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    private final WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @DisplayName("각 당첨 로또 수만큼 저장된다.")
    @Test
    void should_save_when_calculateResult() {
        LottoResultManager lottoResultManager = new LottoResultManager(
                new LottoResults(List.of(
                        new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                        new LottoResult(new Lotto(List.of(1, 2, 3, 4, 7, 8))),
                        new LottoResult(new Lotto(List.of(1, 2, 3, 7, 8, 9))),
                        new LottoResult(new Lotto(List.of(1, 2, 7, 8, 9, 10))),
                        new LottoResult(new Lotto(List.of(1, 7, 8, 9, 10, 11))),
                        new LottoResult(new Lotto(List.of(7, 8, 9, 10, 11, 12))))),
                new LottoStatistics(new HashMap<>()));

        lottoResultManager.calculateResult(winningLotto);

        Map<WinningType, Integer> statistics = lottoResultManager.getStatistics().getStatistics();
        Assertions.assertThat(statistics.get(WinningType.FIRST)).isEqualTo(1);
        Assertions.assertThat(statistics.get(WinningType.SECOND)).isEqualTo(1);
        Assertions.assertThat(statistics.get(WinningType.THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.get(WinningType.FOURTH)).isEqualTo(1);
        Assertions.assertThat(statistics.get(WinningType.FIFTH)).isEqualTo(1);
        Assertions.assertThat(statistics.get(WinningType.OTHER)).isEqualTo(3);
    }
}
