package lotto.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.dto.WinningNumbersDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {
    private LottoService lottoService;
    private List<Lotto> testLotto;

    @BeforeEach
    public void 셋팅() {
        testLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // SIX_MATCH
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // FIVE_WITH_BONUS
                new Lotto(List.of(1, 2, 3, 4, 5, 11)), // FIVE_MATCH
                new Lotto(List.of(2, 3, 4, 5, 6, 11)), // FIVE_MATCH
                new Lotto(List.of(1, 2, 3, 4, 11, 12)), // FOUR_MATCH
                new Lotto(List.of(1, 2, 3, 40, 41, 42)), // THREE_MATCH
                new Lotto(List.of(11, 12, 13, 14, 15, 16)), // NONE
                new Lotto(List.of(11, 12, 13, 14, 15, 16)), // NONE
                new Lotto(List.of(11, 12, 13, 14, 15, 16)), // NONE
                new Lotto(List.of(11, 12, 13, 14, 15, 16)) // NONE
        );

        LottoMachine stubbedLottoMachine = new LottoMachine() {
            private int index = 0;

            @Override
            public Lotto generateLotto() {
                return testLotto.get(index++);
            }
        };

        lottoService = new LottoService(stubbedLottoMachine);
        lottoService.purchaseLottoTickets(10000);
    }

    @Test
    @DisplayName("각 로또 티켓의 당첨 여부가 일치하는지 테스트")
    public void testPrizeStatistics() {

        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);

        Map<Prize, Integer> expectedPrizeCount = Map.of(
                Prize.NONE, 4,
                Prize.THREE_MATCH, 1,
                Prize.FOUR_MATCH, 1,
                Prize.FIVE_MATCH, 2,
                Prize.FIVE_WITH_BONUS, 1,
                Prize.SIX_MATCH, 1
        );

        assertEquals(expectedPrizeCount, lottoResult.getPrizeCount());
    }

    /**
     * 3등 당첨 시나리오 10000원을 투자하여 5천원의 수익을 얻었습니다. 이때 수익률은 50%입니다.
     */
    @Test
    @DisplayName("알맞은 수익률을 계산하여 출력하는지 테스트")
    public void testTotalEarningsRate() {

        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(40, 41, 42, 20, 21, 22), 23);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);

        double expectedEarningsRate = 50.0; // 50%를 소수로 표현
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        assertEquals(expectedEarningsRate, actualEarningsRate); // 오차 범위를 지정

    }
}
