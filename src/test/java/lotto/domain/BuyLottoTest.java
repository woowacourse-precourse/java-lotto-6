package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class BuyLottoTest {
    @Test
    void buyLotto_메서드_동작() {
        long input = 5000;
        int result = (int) input / 1000;

        BuyLotto buyLotto = new BuyLotto();

        assertThat(buyLotto.buyLotto(input).size()).isEqualTo(result);
    }

}
