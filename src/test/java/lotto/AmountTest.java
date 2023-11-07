package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.model.Amount;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    void 최소_구입_금액은_1000원이다() {
        String amount = "500";
        assertThrows(IllegalArgumentException.class,
            () -> new Amount(amount)
        );
    }

    @Test
    void 구입_금액은_1000원_단위로_나누어_떨어져야_한다() {
        String validAmount = "10000";
        String invalidAmount = "1350";

        assertDoesNotThrow(() ->
            new Amount(validAmount)
        );

        assertThrows(IllegalArgumentException.class,
            () -> new Amount(invalidAmount));
    }

    @Test
    void 구입_금액은_숫자여야한다() {
        String amount = "구입금액";
        assertThrows(IllegalArgumentException.class,
            () -> new Amount(amount)
        );
    }
}