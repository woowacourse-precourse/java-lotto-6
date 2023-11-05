package lotto.cashier;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReceivedAmountTest {

    @DisplayName("로또 구매 금액이 1000원 단위 금액이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 9999})
    void validateIsLottoPrice(int amount) {
        //given //when //then
        assertThatThrownBy(() -> ReceivedAmount.create(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
