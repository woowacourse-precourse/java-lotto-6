package lotto.Model;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class LottoGameCalculatorTest {

    private LottoGameCalculator calculator;
    private Lotto winningLotto;
    private WinningNumbers winningNumbers;
    private LottoTicket ticket;
    private List<Lotto> mockLottos;

    @BeforeEach
    public void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumbers = new WinningNumbers(winningLotto, 7);
        calculator = new LottoGameCalculator();

        // 목킹할 Lotto 객체들을 생성합니다.
        mockLottos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Lotto mockLotto = mock(Lotto.class);
            when(mockLotto.getNumbers()).thenReturn(Arrays.asList(1, 2, 3, 10, 11, 12)); // 일부 숫자가 당첨 번호와 일치하도록 설정
            mockLottos.add(mockLotto);
        }

        // LottoTicket을 목킹하여 항상 동일한 Lotto 객체들을 반환하도록 합니다.
        ticket = mock(LottoTicket.class);
        when(ticket.getLottos()).thenReturn(mockLottos);
    }

    @Test
    public void testCalculateWinningStatistics() {
        // 계산된 통계가 예상 통계와 일치하는지 확인합니다.
        Map<Integer, Integer> actualStatistics = calculator.calculateWinningStatistics(ticket, winningNumbers);
        assertEquals(5, actualStatistics.getOrDefault(Prize.MATCH_3.getReward(), 0));
    }

    @Test
    public void testCalculateProfitRate() {
        // 수익률 계산을 위해 통계를 설정합니다.
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(Prize.MATCH_3.getReward(), 5); // 3개 일치, 모든 로또가 3개 일치한다고 가정

        // 구매 금액을 설정합니다.
        int purchaseAmount = 5000 * 5; // 5장 구입, 장당 5000원으로 가정

        // 계산된 수익률이 정확한지 확인합니다.
        double expectedProfitRate = ((5 * Prize.MATCH_3.getReward()) / (double) purchaseAmount) * 100;
        double actualProfitRate = calculator.calculateProfitRate(purchaseAmount, statistics);
        assertEquals(expectedProfitRate, actualProfitRate, 0.01);
    }
}
