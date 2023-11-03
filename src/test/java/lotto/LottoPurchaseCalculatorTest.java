package lotto;

import lotto.Model.LottoPurchaseCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoPurchaseCalculatorTest {

    @Test
    public void 구매금액_배수일_때_티켓_수_테스트() {
        // Given
        int purchaseAmount = 5000; // 5000원으로 테스트
        int expectedTickets = 5; // 예상되는 티켓 수

        // When
        int actualTickets = LottoPurchaseCalculator.calculateNumberOfTickets(purchaseAmount);

        // Then
        Assertions.assertEquals(expectedTickets, actualTickets, "계산된 티켓 수는 예상된 티켓 수와 같아야 합니다.");
    }

}