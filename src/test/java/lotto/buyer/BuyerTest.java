package lotto.buyer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerTest {

    void provideRemoteInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("로또 구매 금액을 입력 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또_구매_금액_입력(int expectedValue) throws Exception {
        //given
        Buyer buyer = new Buyer();
        provideRemoteInput(String.valueOf(expectedValue));

        //when
        int buyAmount = buyer.buyLotto();

        //then
        assertThat(buyAmount).isEqualTo(expectedValue);
    }

}