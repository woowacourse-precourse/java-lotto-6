package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.config.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DepositTest {

    @DisplayName("Deposit 을 생성한다.")
    @Test
    public void createDeposit() {
        int amount = Constant.TICKET_PRICE * 2;
        Deposit deposit = new Deposit(amount);
        assertThat(deposit.getDeposit()).isEqualTo(amount);
    }

    @DisplayName("천원 단위로 나뉘지 않는 deposit 은 예외를 발생한다.")
    @Test
    public void invalidDepositUnit() {
        assertThatThrownBy(
            () -> new Deposit(3400)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천원보다 작은 deposit 은 예외를 발생한다.")
    @Test
    public void depositUnderValue() {
        assertThatThrownBy(
            () -> new Deposit(800)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액을 바탕으로 티켓 구매 개수를 구할 수 있다.")
    @Test
    public void getTicketCount() {
        int ticketCount = 1;

        Deposit deposit = new Deposit(Constant.TICKET_PRICE * ticketCount);
        assertThat(deposit.getLottoTicketsCount()).isEqualTo(ticketCount);
    }
}