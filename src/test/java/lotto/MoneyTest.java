package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MoneyTest {
    @DisplayName("로또 구매금액 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5500, 100_000_001, 100})
    public void 로또구매액의_범위와_단위가_유효하지_않으면_예외가_발생한다(int inputMoney) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(inputMoney));
    }

    @DisplayName("로또 구매개수 테스트")
    @Test
    public void 로또구매액과_구매개수가_일치하지_않으면_예외가_발생한다() {
        Money money = new Money(10000);
        Assertions.assertEquals(10, money.calculateTicketCount());
    }
}
