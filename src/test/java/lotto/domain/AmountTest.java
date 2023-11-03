package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000", "10000"})
    @DisplayName("구입 금액으로 로또 구매 성공")
    public void buyLotto(String money) {
        // given // when
        Amount amount = new Amount(money);

        // then
        assertThat(money).isNotNull();
    }
}