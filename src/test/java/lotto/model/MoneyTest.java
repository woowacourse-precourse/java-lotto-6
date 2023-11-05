package lotto.model;

import static java.lang.Integer.*;
import static lotto.util.ConstantNumbers.TICKET_PRICE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    String input;
    Money money;

    @BeforeEach
    void reset() {
        //Console.close();
        input = "18000";
        money = Money.of(input);
    }

    @Test
    @DisplayName("Money 객체 돈 저장 후 복권 수 계산 확인")
    void testCountLottoTicket() {
        //when
        Integer output = money.countTicketQuantity();

        //then
        assertThat(output * TICKET_PRICE.getConstant()).isEqualTo(parseInt(input));
    }

    @Test
    @DisplayName("수익률 계산")
    void testMoneyException_HasSpace() {
        Integer total = parseInt(input);

        assertThat(money.calculateTotalReturn(total)).isEqualTo(100);
    }
}