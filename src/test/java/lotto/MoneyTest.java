package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("로또구매액의 범위와 단위가 유효하지 않으면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {5500, 100_000_001, 100})
    public void 로또_구매금액_유효성_테스트(int inputMoney) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(inputMoney));
    }

    @DisplayName("로또구매액과 로또구매개수가 일치하면 예외가 발생하지않음")
    @Test
    public void 로또_구매액과_구매개수_일치여부_테스트() {
        Money money = new Money(10000);
        Assertions.assertEquals(10, money.calculateTicketCount());
    }
}
