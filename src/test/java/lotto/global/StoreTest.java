package lotto.global;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {
    @Test
    @DisplayName("입력 금액을 구입 개수로 변환한다.")
    public void testConvertPriceToCount() {
        //given
        int price = 2000;
        int expectedCount = 2;

        //when
        int actualCount = Store.convertPriceToCount(price);

        //then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    @DisplayName("임의의 수를 가진 Lotto 객체를 반환한다.")
    public void testGenerateLotto() throws Exception {
        // given
        Method generateLottoMethod = Store.class.getDeclaredMethod("generateLotto");
        generateLottoMethod.setAccessible(true);

        // when
        Lotto lotto = (Lotto) generateLottoMethod.invoke(Store.class);

        // then
        assertNotNull(lotto);
    }
}