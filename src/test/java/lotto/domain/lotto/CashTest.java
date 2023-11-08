package lotto.domain.lotto;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.INVALID_LOTTO_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CashTest {


    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ValueSource(longs = {0, -1000, -1500})
    public void validatePositiveNumberException(long number) {
        // when // then
        assertThatThrownBy(() -> new Cash(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 false를 반환한다.")
    @DisplayName("Lotto의 금액이 1000으로 나누어 떨어지지 않으면 false를 반환한다.")
    @ValueSource(longs = {1200, 3800200, 948300, 300})
    public void isNotPurchaseLottoPossible(long number) {
        // given
        Cash cash = new Cash(number);
        // when
        boolean isPurchaseLottoPossible = cash.isPurchaseLottoPossible(STANDARD.getLottoPrice());
        // then
        assertThat(isPurchaseLottoPossible).isFalse();
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 true를 반환한다.")
    @DisplayName("Lotto의 금액이 1000으로 나누어 떨어지면 true를 반환한다.")
    @ValueSource(longs = {1000, 300000, 8000, 12000})
    public void isPurchaseLottoPossible(long number) {
        // given
        Cash cash = new Cash(number);
        // when
        boolean isPurchaseLottoPossible = cash.isPurchaseLottoPossible(STANDARD.getLottoPrice());
        // then
        assertThat(isPurchaseLottoPossible).isTrue();
    }

    @Test
    @DisplayName("현금으로 구입 가능한 물건의 개수를 카운트하여 반환한다.")
    public void countPurchasableItems() {
        // given
        Cash cash = new Cash(10000);
        // when
        long countItems = cash.countPurchasableItems(1000);
        // then
        assertThat(countItems).isEqualTo(10000 / 1000);
    }

    @Test
    @DisplayName("물건의 가격이 가지고 있는 돈에서 나누어 떨어지지 않으면 예외가 발생한다.")
    public void countPurchasableItemsException() {
        // given
        Cash cash = new Cash(10000);
        // when //then
        assertThatThrownBy(() -> cash.countPurchasableItems(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_MONEY.getMessage());
    }

}