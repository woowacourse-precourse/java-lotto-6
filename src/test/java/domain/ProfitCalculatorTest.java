package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProfitCalculatorTest {

    @DisplayName("주어진 로또목록과 당첨번호를 토대로 당첨내역이 올바르게 반환하는지 검증합니다.")
    @Test
    void checkGetWinningHistory() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        profitCalculator.calculateProfit(lottos, winningNumbers, bonusNumber);

        HashMap<WinningHistory, Integer> result = profitCalculator.getWinningHistory();

        assertEquals(1, result.get(WinningHistory.FIRST));
        assertEquals(1, result.get(WinningHistory.SECOND));
        assertEquals(0, result.get(WinningHistory.THIRD));
        assertEquals(0, result.get(WinningHistory.FOURTH));
        assertEquals(0, result.get(WinningHistory.FIFTH));
    }

    @Test
    @DisplayName("수익률이 소수점 둘째 자리에서 내림되는지 확인")
    void testCalculateRateOfReturnRoundingDown() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        profitCalculator.calculateProfit(lottos, winningNumbers, bonusNumber);

        String rateOfReturnRoundingUp = profitCalculator.calculateRateOfReturn(1950);
        assertEquals("256.4%", rateOfReturnRoundingUp);
    }

    @Test
    @DisplayName("수익률이 소수점 둘째 자리에서 올림되는지 확인")
    void testCalculateRateOfReturnRoundingUp() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        profitCalculator.calculateProfit(lottos, winningNumbers, bonusNumber);

        String rateOfReturn = profitCalculator.calculateRateOfReturn(2700);

        assertEquals("185.2%", rateOfReturn);
    }
}


