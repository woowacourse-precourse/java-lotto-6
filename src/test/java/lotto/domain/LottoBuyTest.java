package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBuyTest {

    @Test
    @DisplayName("로또 금액을 받아서 몇 장이 구매됐는지 테스트")
    void lottoBuyTest() throws Exception{
        LottoBuy lottoBuy = new LottoBuy();
        Method method = lottoBuy.getClass().getDeclaredMethod("getCount", int.class);
        method.setAccessible(true);

        int amount = 5000;
        int count = (int) method.invoke(lottoBuy, amount);

        assertThat(count).isEqualTo(5);
    }
}
