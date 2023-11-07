package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;
    private WinningLotto winningLotto;
    private Integer bonusNumber;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), //2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), //3등
                new Lotto(List.of(1, 2, 3, 4, 25, 26)), // 4등
                new Lotto(List.of(1, 2, 3, 26, 30, 45)), // 5등
                new Lotto(List.of(1, 2, 3, 4, 5, 11)), //3등
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        bonusNumber = 7;
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber);
        lottoResult = new LottoResult(lottos);
    }

    @Test
    @DisplayName("당첨 결과 확인")
    void checkResult() {
        Map<Rank, Integer> result = lottoResult.checkResult(winningLotto);
        assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(2);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateReturnRatePercentage() {
        Map<Rank, Integer> result = lottoResult.checkResult(winningLotto);
        double returnRatePercentage = lottoResult.calculateReturnRatePercentage(result, 6000);
        assertThat(returnRatePercentage).isEqualTo(550916.67);
    }
}