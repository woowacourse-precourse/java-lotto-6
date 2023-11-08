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
                new Lotto(List.of(13, 14, 15, 16, 17, 18)), //단일 1등 시나리오
                new Lotto(List.of(19, 20, 21, 22, 23, 24)), //단일 2등 시나리오
                new Lotto(List.of(25, 26, 27, 28, 29, 30)), //단일 3등 시나리오
                new Lotto(List.of(31, 32, 33, 34, 35, 36)) // 단일 4등 시나리오
        );

        LottoMachine testMachine = new LottoMachine() {
            private int index = 0;

            @Override
            public Lotto generateLotto() {
                return testLotto.get(index++);
            }
        };

        lottoService = new LottoService(testMachine);
        lottoService.purchaseLottoTickets(10_000);
    }

    @Test
    @DisplayName("각 로또 티켓의 당첨 여부가 일치하는지 테스트")
    public void testPrizeStatistics() {
        // given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = new LottoResult();
        Map<Prize, Integer> expectedPrizeCount = Map.of(
                Prize.NONE, 4,
                Prize.THREE_MATCH, 1,
                Prize.FOUR_MATCH, 1,
                Prize.FIVE_MATCH, 2,
                Prize.FIVE_WITH_BONUS, 1,
                Prize.SIX_MATCH, 1
        );

        // when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);

        // then
        assertEquals(expectedPrizeCount, lottoResult.getPrizeCount());
    }

    @Test
    @DisplayName("5등 당첨 10000원을 투자하여 5000원을 얻었을때의 수익률")
    public void testTotalEarningsRate_Fifth() {
        // given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(40, 41, 42, 11, 21, 32), 31);
        LottoResult lottoResult = new LottoResult();
        double expectedEarningsRate = 50.0;

        // when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10_000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        // then
        assertEquals(expectedEarningsRate, actualEarningsRate);
    }

    @Test
    @DisplayName("4등 당첨 10000원을 투자하여 5만원을 얻었을때의 수익률")
    public void testTotalEarningsRate_Fourth() {
        // given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(31, 32, 33, 34, 1, 41), 21);
        LottoResult lottoResult = new LottoResult();
        double expectedEarningsRate = 500.0;

        // when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10_000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        // then
        assertEquals(expectedEarningsRate, actualEarningsRate);
    }

    @Test
    @DisplayName("3등 당첨 10000원을 투자하여 150만원을 얻었을때의 수익률")
    public void testTotalEarningsRate_Third() {
        //given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(40, 25, 26, 27, 28, 29), 1);
        LottoResult lottoResult = new LottoResult();
        double expectedEarningsRate = 15_000.0;

        //when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10_000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        //then
        assertEquals(expectedEarningsRate, actualEarningsRate);
    }

    @Test
    @DisplayName("2등 당첨 10000원을 투자하여 3000만원을 얻었을때의 수익률")
    public void testTotalEarningsRate_Second() {
        //given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(40, 19, 20, 21, 22, 23), 24);
        LottoResult lottoResult = new LottoResult();
        double expectedEarningsRate = 300_000.0;

        //when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10_000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        //then
        assertEquals(expectedEarningsRate, actualEarningsRate);
    }

    @Test
    @DisplayName("1등 당첨 10000원을 투자하여 20억원을 얻었을때의 수익률")
    public void testTotalEarningsRate_First() {
        // given
        WinningNumbersDto winningNumbers = new WinningNumbersDto(List.of(13, 14, 15, 16, 17, 18), 23);
        LottoResult lottoResult = new LottoResult();
        double expectedEarningsRate = 20_000_000.0;

        // when
        lottoResult.calculateResults(lottoService.getLottoDtos(), winningNumbers);
        LottoStatistics statistics = new LottoStatistics(lottoResult, 10_000);
        double actualEarningsRate = statistics.calculateEarningsRate();

        // then
        assertEquals(expectedEarningsRate, actualEarningsRate);
    }
}
