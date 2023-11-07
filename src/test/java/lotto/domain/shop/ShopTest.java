package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.SaleLotto;
import lotto.domain.lottomachine.RandomLottoMachine;
import lotto.mock.TestLottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShopTest {

    private final Shop shop = new Shop(new RandomLottoMachine());

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    void sellLottoByWrongPrice() {
        //given
        int price = 1001;
        //when
        //then
        assertThatThrownBy(() -> shop.sellLotto(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원 단위 입니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위라면 로또를 구매한다.")
    void sellLottoSucceed() {
        //given
        int price = 5000;
        //when
        List<SaleLotto> lottos = shop.sellLotto(price);
        //then
        Assertions.assertThat(lottos).hasSize(5);
    }


}