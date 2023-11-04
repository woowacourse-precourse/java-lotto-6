package lotto.model;

import static lotto.utils.LottoException.NOT_VALID_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBuyerTest {
    LottoBuyer buyer;

    @BeforeEach
    void setBuyer() {
        buyer = new LottoBuyer();
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {500, 1234, 2001, 16300})
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
}
