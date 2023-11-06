package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MoneyTest {
    @Test
    public void 로또_구매_단위_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(5500));
    }

    @Test
    public void 로또_최대금액_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(100_000_001));
    }

    @Test
    public void 로또_최소금액_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(100));
    }

    @Test
    public void 로또_구매개수_테스트() {
        Money money = new Money(10000);
        Assertions.assertEquals(10, money.calculateTicketCount());
    }
}
