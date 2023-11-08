package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeLottoCountTest {

    @Test
    @DisplayName("구입 금액을 받아서 로또 개수를 반환한다.")
    void makeLottoCount() {
        //given
        int purchaseCount = 5000;
        //when
        int count = MakeLottoCount.getLottoCount(purchaseCount);
        //then
        assertEquals(count, 5);
    }

}