package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.factory.LottosFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosFactoryTest {

    @DisplayName("해당 금액에 맞는 갯수의 로또를 가지고있는 Lottos를 만든다")
    @Test
    void createLottosTest() {
        //given
        LottosFactory lottosFactory = new LottosFactory();

        //when
        Lottos lottos = lottosFactory.createLottos(10000);
        int amount = lottos.getLottos().size();

        //then
        assertEquals(10, amount);

    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 에러 발생")
    @Test
    void validateMoneyTest() {
        assertThatThrownBy(() -> new LottosFactory().createLottos(800))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
