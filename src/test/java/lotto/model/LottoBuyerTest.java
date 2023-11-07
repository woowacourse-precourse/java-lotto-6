package lotto.model;

import static lotto.exception.LottoException.LESS_THAN_MINIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.NOT_VALID_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.ApplicationConfig;
import lotto.model.trade.LottoBuyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBuyerTest {
    ApplicationConfig applicationConfig;
    LottoBuyer buyer;

    @BeforeEach
    void setBuyer() {
        applicationConfig = new ApplicationConfig();
        buyer = applicationConfig.lottoBuyer();
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 1234, 2001, 16300})
    void testPurchaseAmountNonMultipleOfThousand(int purchaseAmount) {
        //when, then
        assertThatThrownBy(() -> buyer.pay(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_VALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("로또 구입 금액이 1,000원 단위일 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 11000, 9000, 20000})
    void testPurchaseAmountMultipleOfThousand(int purchaseAmount) {
        //when, then
        assertDoesNotThrow(() -> buyer.pay(purchaseAmount));
    }

    @DisplayName("로또 구입 금액이 1,000원보다 작을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void testPurchaseAmountLessThanMinimumAmount(int purchaseAmount) {
        //when, then
        assertThatThrownBy(() -> buyer.pay(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LESS_THAN_MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("로또 구입 금액이 20,000원보다 클 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {21000, 50000, 100000})
    void testPurchaseAmountMoreThanMaximumAmount(int purchaseAmount) {
        //when, then
        assertThatThrownBy(() -> buyer.pay(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MORE_THAN_MAXIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("로또 구입 금액이 1,000원 이상 20,000원 이하인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 9000, 16000, 20000})
    void testPurchaseAmountValidRange(int purchaseAmount) {
        //when, then
        assertDoesNotThrow(() -> buyer.pay(purchaseAmount));
    }

    @DisplayName("구매한 금액 만큼 로또 개수를 반환해야 한다.")
    @Test
    void testLottoCountByPurchaseAmount() {
        //given
        int purchaseAmount = 4000;

        //when
        buyer.pay(purchaseAmount);

        //then
        assertThat(buyer.getCountOfLotto()).isEqualTo(4);
    }
}
