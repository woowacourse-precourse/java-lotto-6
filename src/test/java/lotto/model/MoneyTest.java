package lotto.model;

import static java.lang.Integer.*;
import static lotto.exception.ErrorMessage.HAS_SPACE;
import static lotto.util.ConstantNumbers.TICKET_PRICE;
import static org.assertj.core.api.Assertions.*;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("Money 객체 돈 저장 후 복권 수 계산 확인")
    void testCountLottoTicket() {
        //given
        String input = "18000";
        Money money = Money.of(input);

        //when
        Integer output = money.countTicketQuantity();

        //then
        assertThat(output * TICKET_PRICE.getConstant()).isEqualTo(parseInt(input));
    }

    @Test
    @DisplayName("input 공백 포함으로 인한 예외 확인")
    void testMoneyException_HasSpace() {
        String input = "180 00";

        assertThatThrownBy(() -> Money.of(input)).isInstanceOf(LottoException.class).hasMessageContaining(HAS_SPACE.getMessage());
    }
}