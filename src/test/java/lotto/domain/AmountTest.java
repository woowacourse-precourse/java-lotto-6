package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.utils.message.ErrorMessage;
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

    @ParameterizedTest
    @ValueSource(strings = {"wrong", "%%"})
    @DisplayName("구입 금액이 숫자가 아니면 에러가 발생한다.")
    public void buyLottoByNonNumber(String money) {
        assertThatThrownBy(() -> new Amount(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1100", "1110", "1111"})
    @DisplayName("구입 금액이 1,000원 단위가 아니면 에러가 발생한다.")
    public void buyLottoByInDivisibleAmount(String money) {
        assertThatThrownBy(() -> new Amount(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INDIVISIBLE_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "999"})
    @DisplayName("구입 금액이 1,000원 미만이면 에러가 발생한다.")
    public void buyLottoByWrongRangeAmount(String money) {
        assertThatThrownBy(() -> new Amount(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_AMOUNT_RANGE);
    }
}