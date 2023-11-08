package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.configuration.Constants.Config.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    private static final int ERROR_INPUT_NOT_MULTIPLE = PRICE + 1;
    private static final int ERROR_INPUT_NEGATIVE = -1;
    private static final int ERROR_INPUT_ZERO = 0;

    private static final int LOTTO_COUNT = 8;
    private static final int PURCHASE_AMOUNT = LOTTO_COUNT * PRICE;

    @Test
    @DisplayName("money 객체 생성 시 로또 가격으로 나누어 떨어지지 않으면 에러가 발생한다.")
    public void createMoneyByNotMultiple() {
        // when & then
        assertThatThrownBy(() -> new Money(ERROR_INPUT_NOT_MULTIPLE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("money 객체 생성 시 음수 인풋은 에러가 발생한다.")
    public void createMoneyByNegative() {
        // when & then
        assertThatThrownBy(() -> new Money(ERROR_INPUT_NEGATIVE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("money 객체 생성 시 0은 에러가 발생한다.")
    public void createMoneyByZero() {
        // when & then
        assertThatThrownBy(() -> new Money(ERROR_INPUT_ZERO))
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