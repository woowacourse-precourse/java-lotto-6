package lotto.domain;

import static lotto.constants.ErrorMessage.INSUFFICIENT_BALANCE;
import static lotto.constants.ErrorMessage.INVALID_AMOUNT;
import static lotto.constants.LottoOption.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BalanceTest {
    private Balance balance;

    @BeforeEach
    void setUp() {
        balance = Balance.create(2000); // Initial balance for tests
    }

    @DisplayName("초기 투입 금액을 뜻하는 purchaseAmount는 deductTicketPrice를 수행하더라도 차감되지 않는다.")
    @Test
    void purchaseAmountNotDedicate() {
        balance.deductTicketPrice();
        System.out.println(balance.getPurchaseAmount());
        assertThat(balance.getPurchaseAmount()).isEqualTo(2000);
    }

    @DisplayName("충분한 잔액이 없는 경우 티켓 가격을 차감하려고 시도하면 예외가 발생한다.")
    @Test
    void deductTicketPriceWithInsufficientBalance() {
        balance.deductTicketPrice();
        balance.deductTicketPrice();
        assertThatThrownBy(() -> balance.deductTicketPrice())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(INSUFFICIENT_BALANCE.getMessage());
    }

    @DisplayName("생성된 Balance 객체의 getPurchaseAmount() 메서드가 올바른 값을 반환한다.")
    @Test
    void getPurchaseAmount() {
        assertThat(balance.getPurchaseAmount()).isEqualTo(2000);
    }

    @DisplayName("로또 티켓 가격의 배수가 아닌 금액으로 Balance 객체를 생성하면 예외가 발생한다.")
    @Test
    void createBalanceWithInvalidAmount() {
        int invalidAmount = 1500;

        assertThatThrownBy(() -> Balance.create(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_AMOUNT.getMessage(), LOTTO_TICKET_PRICE.getValue()));
    }
}