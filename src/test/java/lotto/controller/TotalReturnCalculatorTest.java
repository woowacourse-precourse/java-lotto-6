package lotto.controller;

import lotto.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalReturnCalculatorTest {
    public final int NUMBER_OF_BONUS = 1;
    public final int NUMBER_OF_THIRD = 1;
    public final int NUMBER_OF_PURCHASE_LOTTO = 8;
    private TotalReturnCalculator totalReturnCalculator = new TotalReturnCalculator();

    @Test
    public void testCalculateTotalReturn_1() {
        // given
        WinningDetail winningDetail = new WinningDetail();
        winningDetail.add(new CountOfCorrectLotto(Winning.THIRD, NUMBER_OF_THIRD));
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(NUMBER_OF_PURCHASE_LOTTO);
        // when
        Double totalReturn = totalReturnCalculator.calculateTotalReturn(winningDetail, numberOfPurchaseLotto);
        Double totalPrize = (double) Winning.THIRD.getPrize() * NUMBER_OF_THIRD;
        Double totalPayment =  (double) NUMBER_OF_PURCHASE_LOTTO * LottoMetaData.PRICE.getValue();
        Double expectTotalReturn = totalPrize / totalPayment * 100.0;
        System.out.println(expectTotalReturn);
        // then
        assertEquals(expectTotalReturn, totalReturn);
    }
}
