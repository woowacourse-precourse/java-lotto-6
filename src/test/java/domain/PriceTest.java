package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.ConstantOfLotto;

class PriceTest {
    private Price price;

    @DisplayName("구매 금액으로 몇 개의 로또를 살 수 있는지 알 수 있다. (로또 개수 = 구매 금액 / 로또 1개 금액)")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,10000,500000})
    void priceCanShowNumOfLotto(int money) {
        price = new Price(money);
        Assertions.assertEquals(price.numOfLotto(),money/ ConstantOfLotto.priceOfLotto);
    }
}