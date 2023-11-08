package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    private static final String MONEY_UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String MONEY_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000,000원 이하로 입력해야 합니다.";
    private static final int MAX_PURCHASE_PRICE = 1_000_000;
    private static final int LOTTO_PER_PRICE = 1_000;

    @DisplayName("구매 금액이 100만원 초과 시 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {MAX_PURCHASE_PRICE + LOTTO_PER_PRICE})
    void meetsBound(int money) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> new Money(money));

        assertTrue(thrown.getMessage().equals(MONEY_AMOUNT_ERROR));
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 1100})
    void meetsUnit(int money) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> new Money(money));

        assertTrue(thrown.getMessage().equals(MONEY_UNIT_ERROR));
    }

    @DisplayName("10,000원은 로또 10장의 금액이다.")
    @Test
    void calculatePurchasedCount() {
        Money money = new Money(10_000);

        assertThat(money.countPurchasedCount()).isEqualTo(10);
    }
}