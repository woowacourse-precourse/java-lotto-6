package lotto.global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {
    @DisplayName("입력 금액을 구입 개수로 변환한다.")
    @Test
    public void testConvertPriceToCount() {
        //given
        int price = 2000;
        int expectedCount = 2;

        //when
        int actualCount = Store.convertPriceToCount(price);

        //then
        assertEquals(expectedCount, actualCount);
    }
}