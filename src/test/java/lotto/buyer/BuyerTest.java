package lotto.buyer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest {

    void provideRemoteInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("로또 구매 금액을 입력 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또_구매금액_입력(int expectedValue) throws Exception {
        //given
        Buyer buyer = new Buyer();
        provideRemoteInput(String.valueOf(expectedValue));

        //when
        int buyAmount = buyer.buyLotto();

        //then
        assertThat(buyAmount).isEqualTo(expectedValue);
    }

    @DisplayName("로또 구매 금액 예외처리 - 숫자가 아닌 경우 예외 발생")
    @Test
    void 로또_구매금액_입력_예외처리_숫자가_아닌_경우() throws Exception {
        //given
        Buyer buyer = new Buyer();
        String expectedValue = "난문자";
        provideRemoteInput(expectedValue);

        //when & then
        assertThatThrownBy(() -> buyer.buyLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

}