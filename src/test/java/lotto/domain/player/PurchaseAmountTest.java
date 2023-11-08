package lotto.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.config.GameConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.PURCHASE_UNIT_INVALID;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("적합한 단위의 구입 금액으로 PurchaseAmount를 생성하였을 때 예외를 반환하지 않는다.")
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void create_sucess(int randomNumber) {
        // given
        Integer purchaseAmount = randomNumber;

        // when, then
        assertThatCode(() -> {
            PurchaseAmount.create(purchaseAmount);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("적합하지 않은 단위의 구입 금액으로 PurchaseAmount를 생성하였을 때 예외를 반환하지 않는다.")
    @ValueSource(ints = {500, 1500, 70, 300, 201})
    void create_fail(int randomNumber) {
        // given
        Integer purchaseAmount = randomNumber;

        // when, then
        assertThatThrownBy(() -> PurchaseAmount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        PURCHASE_UNIT_INVALID.getMessage(),
                        LOTTO_PRICE.getNumber())
                );
    }

    @Test
    @DisplayName("주어진 구입 금액을 로또 가격으로 나누어 구입 가능 로또 개수를 반환한다.")
    void calculatePurchasedLottoCount() {
        //given
        Integer number = 5000;
        PurchaseAmount purchaseAmount = PurchaseAmount.create(5000);

        //when
        int purchasedLottoCount = purchaseAmount.calculatePurchasedLottoCount(purchaseAmount);

        //then
        Assertions.assertThat(purchasedLottoCount).isEqualTo(5);

    }
}