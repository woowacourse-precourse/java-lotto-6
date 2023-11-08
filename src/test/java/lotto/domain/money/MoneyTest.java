package lotto.domain.money;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.money.exception.InvalidMoneyAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class MoneyTest {

    @DisplayName("0 이상의 금액으로 입력하여 Money 생성 가능")
    @ParameterizedTest
    @ValueSource(ints = {0, 1_000, 1_000_000})
    void from_amountEqualsOrMoreThanZero_shouldCreateInstance(final int amount) {
        // when
        // then
        Money.from(amount);
    }

    @DisplayName("0 미만의 금액으로 입력하여 Money 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1_000, -1_000_000})
    void from_amountLessThanZero_shouldThrowException(final int amount) {
        // when
        // then
        assertThatThrownBy(() ->
                Money.from(amount))
                .isInstanceOf(InvalidMoneyAmountException.class)
                .hasMessage(InvalidMoneyAmountException.INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE);
    }

    @DisplayName("isLess는 비교하는 액수에 따라 다른 boolean 값 반환")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 1_000_000})
    void isLessThan_withGreaterAmount_shouldReturnTrue(final int amount) {
        // given
        final Money money = Money.from(amount);

        final Money price1 = Money.from(amount + 1);
        final Money price2 = Money.from(amount - 1);
        final Money price3 = Money.from(amount);

        // when
        final boolean isLess =
                money.isLessThan(price1);
        final boolean isNotLess =
                money.isLessThan(price2);
        final boolean isEqual =
                money.isLessThan(price3);

        // then
        assertThat(isLess).isTrue();
        assertThat(isNotLess).isFalse();
        assertThat(isEqual).isFalse();
    }

    @DisplayName("현재 가진 잔액이 소비 금액보다 크거나 같을 경우 잔액 정상 차감")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 1_000_000})
    void spend_lessThanAmount_shouldDecreaseAmount(final int amount) {
        // given
        final Money money = Money.from(amount);

        final Money price1 = Money.from(amount - 1);
        final Money price2 = Money.from(amount);

        // when
        final Money moneyDecreased1 = money.decreased(price1);
        final Money moneyDecreased2 = money.decreased(price2);

        // then
        assertThat(moneyDecreased1)
                .extracting("amount").isEqualTo(1L);
        assertThat(moneyDecreased2)
                .extracting("amount").isEqualTo(0L);
    }

    @DisplayName("현재 가진 잔액 이상을 소비하는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 1_000, 1_000_000})
    void spend_moreThanAmount_shouldThrowException(final int amount) {
        // given
        final Money money = Money.from(amount);
        final Money price = Money.from(amount + 1);
        // when
        // then
        assertThatThrownBy(() ->
                money.decreased(price))
                .isInstanceOf(InvalidMoneyAmountException.class)
                .hasMessage(InvalidMoneyAmountException.INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE);
    }
}