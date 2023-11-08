package lotto.money;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyUtilsTest {

    @Test
    public void 수익률_검증_1() {
        Money purchaseAmount = new Money(2000);
        Money earningAmount = new Money(5000);

        Double yieldRate = MoneyUtils.calculateYieldRate(purchaseAmount, earningAmount);

        assertEquals(250, yieldRate);
    }

    @Test
    public void 수익률_검증_2() {
        Money purchaseAmount = new Money(2000);
        Money earningAmount = new Money(120000);

        Double yieldRate = MoneyUtils.calculateYieldRate(purchaseAmount, earningAmount);

        assertEquals(6000, yieldRate);
    }

    @Test
    public void 손실이_발생한_경우() {
        Money purchaseAmount = new Money(2000);
        Money earningAmount = new Money(1000);

        Double yieldRate = MoneyUtils.calculateYieldRate(purchaseAmount, earningAmount);

        assertEquals(50, yieldRate);
    }


    @Test
    public void 수익이_없을_경우_수익률은_0이다() {
        Money purchaseAmount = new Money(2000);
        Money earningAmount = new Money(0);

        Double yieldRate = MoneyUtils.calculateYieldRate(purchaseAmount, earningAmount);

        assertEquals(0, yieldRate);
    }

}