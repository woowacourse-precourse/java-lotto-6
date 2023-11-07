package lottoTicketPurchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketQuantityTest {
    private LottoTicketQuantity ticketQuantity;

    @BeforeEach
    void setup() {
        ticketQuantity = new LottoTicketQuantity();
    }

    @DisplayName("숫자를 넣으면 1000으로 나눈 값을 반환한다.")
    @Test
    void inputNumber() {
        Assertions.assertEquals(1, ticketQuantity.getPurchaseQuantity(1000));
        Assertions.assertEquals(100, ticketQuantity.getPurchaseQuantity(100000));
    }
}