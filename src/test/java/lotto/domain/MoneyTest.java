package lotto.domain;

import lotto.configuration.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    private static final int ERROR_INPUT = Constants.Rule.PRICE + 1;

    private static final int LOTTO_COUNT = 8;
    private static final int PURCHASE_AMOUNT = LOTTO_COUNT * Constants.Rule.PRICE;

    @Test
    @DisplayName("로또 가격으로 나누어 떨어지지 않으면 에러가 발생한다.")
    public void createMoneyByNotMultipleOfPrice() {
        // when & then
        assertThatThrownBy(() -> new Money(ERROR_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("money를 로또 가격으로 나눈 값은 로또를 살 수 있는 횟수이다")
    public void getLottoCount() {
        // given
        Money money = new Money(PURCHASE_AMOUNT);

        // when
        int actualLottoCount = money.getLottoCount();

        // then
        Assertions.assertThat(actualLottoCount).isEqualTo(LOTTO_COUNT);
    }
}