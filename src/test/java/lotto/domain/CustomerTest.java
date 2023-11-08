package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createCustomerWithMoneyNotInCondition() {
        assertThatThrownBy(() -> new Customer(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createCustomerWithSmallMoney() {
        assertThatThrownBy(() -> new Customer(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 전체 상금이 얼마인지 계산")
    @Test
    void getTotalPrize() {

        //given
        Customer customer = new Customer(3000);
        customer.getPrizes().put(Reward.MATCH_THREE, 5);
        customer.getPrizes().put(Reward.MATCH_FOUR, 2);
        //when
        int prizeSum = customer.getTotalPrize();
        //then
        assertThat(prizeSum).isEqualTo(125000);
    }

    @DisplayName("입력된 금액에 맞는 티켓 수 계산")
    @Test
    void getTicketNumber() {
        //given
        Customer customer = new Customer(3000);
        //when
        int ticketNumber = customer.getNumberOfLottoTicket();
        //then
        assertThat(ticketNumber).isEqualTo(3);
    }
}
