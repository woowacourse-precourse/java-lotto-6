package lotto.domain.money;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.money.exception.InvalidMoneyAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class WalletTest {

    @DisplayName("spend 호출 시 내부 Money가 차감된다.")
    @ParameterizedTest
    @ValueSource(longs = {1_000, 2_000, 3_000, 5_000_000})
    void spend_withMoney_shouldDecreaseAmount(final long amount) {
        // given
        final Wallet wallet = new Wallet(Money.from(amount));

        // when
        wallet.spend(Money.from(amount));

        // then
        assertThat(wallet.hasEqualOrMoreThan(Money.zero())).isTrue();
        assertThat(wallet.hasEqualOrMoreThan(Money.from(1))).isFalse();
    }

    @DisplayName("잔액 이상 spend 시 예외 발생")
    @ParameterizedTest
    @ValueSource(longs = {1_000, 2_000, 3_000, 5_000_000})
    void spend_withMoneyOverAmount_shouldThrowException(final long amount) {
        // given
        final Wallet wallet = new Wallet(Money.from(amount));

        // when
        // then
        assertThatThrownBy(() ->
                wallet.spend(Money.from(amount + 1)))
                .isInstanceOf(InvalidMoneyAmountException.class)
                .hasMessage(InvalidMoneyAmountException.INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE);
    }
}