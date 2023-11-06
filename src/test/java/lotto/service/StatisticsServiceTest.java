package lotto.service;

import lotto.domain.*;
import lotto.repository.PrizeMoneyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class StatisticsServiceTest {
    private StatisticsService statisticsService;
    private WinningLotto winningLotto;
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        statisticsService = new StatisticsService(new PrizeMoneyRepository());
        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        userLottos = getLottos();
    }

    @Test
    @DisplayName("사용자가 구매한 총 로또와 당첨 번호를 비교하여 전체 당첨 내역을 알 수 있다.")
    void checkLottoResult() {
        Map<LottoRanking, Integer> result = statisticsService.checkLottoResult(winningLotto, userLottos);

        assertThat(result).contains(
                entry(LottoRanking.FIFTH, 1),
                entry(LottoRanking.NOTHING, 7)
        );
    }
    
    @Test
    @DisplayName("사용자가 구매한 로또 번호의 결과를 통해 수익률을 계산할 수 있다.")
    void calculateRateOfReturn() {
        Map<LottoRanking, Integer> lottoResult = statisticsService.checkLottoResult(winningLotto, userLottos);
        double result = statisticsService.calculateRateOfReturn(lottoResult, userLottos);

        assertThat(result).isEqualTo(62.5);
    }

    private List<Lotto> getLottos() {
        return List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
    }
}