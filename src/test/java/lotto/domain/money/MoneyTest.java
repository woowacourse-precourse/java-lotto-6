package lotto.domain.money;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 후, 구입 금액은 감소한다.")
    @Test
    void should_Not_Be_Equal_When_Initial_Money_Given_And_Decremented() {
        // given
        Money money = Money.fromInitialMoney(5_000);

        // when
        Money decrementedMoney = money.decremented();

        // then
        assertNotEquals(money, decrementedMoney);
    }

    @DisplayName("로또 한 장 이상을 구매하기에 구입 금액이 부족하다.")
    @Test
    public void should_Return_False_When_If_Not_Enough_With_Money() {
        // Given
        Money money = Money.fromRemainingMoney(1_000);

        // When
        boolean notEnough = money.isNotEnough();

        // Then
        assertFalse(notEnough);
    }

    @DisplayName("로또 한 장 이상을 구매하기에 구입 금액이 충분하다.")
    @Test
    public void should_Return_True_When_If__Enough_With_Money() {
        // given
        Money money = Money.fromInitialMoney(3_000);

        // when
        boolean enough = money.isEnough();

        // then
        assertTrue(enough);
    }
}