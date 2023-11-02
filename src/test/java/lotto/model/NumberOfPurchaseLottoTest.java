package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfPurchaseLottoTest {
    @Test
    public void testNumberOfPurchaseLottoTest(){
        int NUMBER_OF_PURCHASE_LOTTO = 200;
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(NUMBER_OF_PURCHASE_LOTTO);
        assertEquals(NUMBER_OF_PURCHASE_LOTTO, numberOfPurchaseLotto.getNumberOfPurchaseLotto());
    }
}
