package lotto.domain;

import static lotto.domain.enums.ErrorMessage.MONEY_AMOUNT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    void createMoneyByNotMultiple() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_AMOUNT_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    void createMoneyByNegative() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_AMOUNT_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_AMOUNT_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("1000의 배수인 구입 금액을 생성한다.")
    void createMoney() {
        assertDoesNotThrow(() -> new Money(10000));
    }

    @Test
    @DisplayName("구매 개수 구하기")
    void PurchasedCount() {
        //given
        Money money = new Money(10000);

        //when
        int purchaseLottoCount = money.getPurchaseLottoCount();

        //then
        assertThat(purchaseLottoCount).isEqualTo(10);
    }

}