package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsTest {

    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createTicketsLowerPrice() {
        assertThatThrownBy(() -> Tickets.buyTickets(900))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매는 1000원단위로 구매 가능하다.")
    @Test
    void createTicketsNotUnitPrice() {
        assertThatThrownBy(() -> Tickets.buyTickets(1900))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void buyTickets() {
        // given
        int purchaseAmount = 1000;
        // when
        Tickets tickets = Tickets.buyTickets(purchaseAmount);
        // then
        assertEquals(1, tickets.getNumberOfTickets());
    }

    @Test
    void getUserMoney() {
        // given
        int purchaseAmount = 1000;
        Tickets tickets = Tickets.buyTickets(purchaseAmount);
        // when
        int userMoney = tickets.getUserMoney();
        // then
        assertEquals(purchaseAmount, userMoney);
    }
}