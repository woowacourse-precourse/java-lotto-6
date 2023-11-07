package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FinanceManagerTest {

    private FinanceManager financeManager;

    @Test
    void 구매_금액을_로또_금액으로_나눈_값을_로또_개수로_반환() {
        // given
        financeManager = FinanceManager.from(8000);

        // when & then
        assertEquals(8, financeManager.calculateLottoCount());
    }
}
