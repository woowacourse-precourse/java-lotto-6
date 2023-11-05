package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @DisplayName("로또 당첨 수익률을 계산합니다.")
    @Test
    void testCalculateReturnRate() {
        int purchaseAmount = 8;
        Buyer kim = new Buyer(purchaseAmount, new LottoMachine());
        long prizeSum = 5000L;

        double result = kim.calculateReturnRate(prizeSum);
        double expected = 62.5;

        assertEquals(expected, result);
    }

    @DisplayName("구매한 복권이 없을 때 복권 정보 요청시 예외 발생")
    @Test
    void testGetMyLotteries() {
        Buyer test = new Buyer(10, new LottoMachine());

        AssertionsForClassTypes.assertThatThrownBy(() -> test.getMyLotteries())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("구매한 복권 정보가 없습니다.");
    }
}