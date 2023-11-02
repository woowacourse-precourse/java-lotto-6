package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfPurchaseLottoTest {
    @Test
    public void testNumberOfPurchaseLottoTest(){
        int lottoPurchasePayment = 2000;
        int lottoPrice = 1000;
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(lottoPurchasePayment);
        assertEquals(lottoPurchasePayment/lottoPrice, numberOfPurchaseLotto.getNumberOfPurchaseLotto());
    }
}
