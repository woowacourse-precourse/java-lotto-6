package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoIssuerTest {

    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_QUANTITY = 10;
    private LottoIssuer issuer;

    @BeforeEach
    void init() {
        issuer = new LottoIssuer();
    }

    @Test
    @DisplayName("buy: 1000원 단위의 금액을 입력하면 로또 발급에 성공한다")
    void buy() {
        int price = LOTTO_PRICE * PURCHASE_QUANTITY;

        Lottos lottos = issuer.buy(price);
        assertThat(lottos.getLottos().size()).isEqualTo(PURCHASE_QUANTITY);
    }

    @ParameterizedTest
    @DisplayName("buy: 1000원 단위가 아닌 금액을 입력하면 예외가 발생한다")
    @ValueSource(ints = {100, 1001, -1001})
    void buy_잘못된_단위(int price) {

        assertThatThrownBy(() -> issuer.buy(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PRICE_VALUE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("buy: 양수가 아닌 금액을 입력하면 예외가 발생한다")
    @ValueSource(ints = {0, -1000, -10000})
    void buy_음수(int price) {

        assertThatThrownBy(() -> issuer.buy(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.NEGATIVE_PRICE_VALUE.getMessage());
    }
}