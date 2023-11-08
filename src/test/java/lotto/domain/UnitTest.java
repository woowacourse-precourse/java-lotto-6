package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @DisplayName("구매할수 있는 로또 개수를 계산한다.")
    @Test
    void calculateLottoTicketCanPurchase() {
        Assertions.assertEquals(50, Unit.calculateLottoTicketCanPurchase(50000));
    }
}
