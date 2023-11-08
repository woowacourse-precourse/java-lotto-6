package lotto.Test.FunctionTest;

import lotto.model.lottoResultChecker.LottoTotalWinnings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTotalWinningsTest {

    private LottoTotalWinnings lottoTotalWinnings;

    @BeforeEach
    void setUp() {
        lottoTotalWinnings = new LottoTotalWinnings(1000);
    }

    @Test
    @DisplayName("당첨된 티켓의 개수에 따라 총 당첨금액을 올바르게 계산해야 한다")
    void CalculateTotalWinningsTest() {
        int numberOfWinningTickets = 50;
        long expectedTotalWinnings = 50 * 1000;

        long actualTotalWinnings = lottoTotalWinnings.calculateTotalSales(numberOfWinningTickets);

        assertEquals(expectedTotalWinnings, actualTotalWinnings,
                "당첨된 티켓의 개수에 따른 총 당첨금액 계산이 정확해야 한다.");
    }

    @Test
    @DisplayName("당첨된 티켓의 개수가 0일 경우 총 당첨금액도 0이어야 한다")
    void tCalculateNoWinningTest() {
        int numberOfWinningTickets = 0;
        long expectedTotalWinnings = 0;

        long actualTotalWinnings = lottoTotalWinnings.calculateTotalSales(numberOfWinningTickets);

        assertEquals(expectedTotalWinnings, actualTotalWinnings,
                "당첨된 티켓의 개수가 0일 경우 총 당첨금액도 0이어야 한다.");
    }

}

