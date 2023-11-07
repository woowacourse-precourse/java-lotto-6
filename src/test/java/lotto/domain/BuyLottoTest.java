package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class BuyLottoTest {

    @Test
    @DisplayName("돈을 입력받으면 몇장을 사는지 보여준다.")
    void 로또_장수_테스트() throws Exception{
        //given
        BuyLotto buyLotto = new BuyLotto();
        Method method = buyLotto.getClass().getDeclaredMethod("countLottoQuantity", int.class);
        method.setAccessible(true);

        //when
        int money = 2000;

        //then
        int lottoQuantity = (int) method.invoke(buyLotto, money);
        assertThat(lottoQuantity).isEqualTo(2);
    }
}