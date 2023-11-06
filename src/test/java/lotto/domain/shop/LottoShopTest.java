package lotto.domain.shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoShopTest {

    private final LottoShop lottoShop = new LottoShop();

    @DisplayName("돈을 지불했을 때, 알맞는 개수의 로또를 판매한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3"})
    void purchaseTest(int cash, int expectedCount) {
        // when
        int purchasableCount = lottoShop.countPurchasableAmount(cash);

        // then
        Assertions.assertThat(purchasableCount)
                .isEqualTo(expectedCount);
    }

    @DisplayName("로또 구매액 한도에 대해,")
    @Nested
    class purchaseLimit {

        @DisplayName("구매 한도액 초과 시, 예외가 발생한다.")
        @Test
        void purchaseWithOverPurchaseLimit() {
            // given
            int purchaseLimitValue = ShopConfig.LOTTO_PURCHASE_LIMIT.getValue();
            int oneLottoPriceValue = ShopConfig.LOTTO_PRICE.getValue();
            int overLimitValue = purchaseLimitValue + oneLottoPriceValue;

            // then
            Assertions.assertThatThrownBy(() -> lottoShop.countPurchasableAmount(overLimitValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ShopExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }

        @DisplayName("구매 한도액으로 구매 시, 예외가 발생하지 않는다.")
        @Test
        void purchaseWithPurchaseLimit() {
            // given
            int purchaseLimitValue = ShopConfig.LOTTO_PURCHASE_LIMIT.getValue();

            // then
            Assertions.assertThatCode(() -> lottoShop.countPurchasableAmount(purchaseLimitValue))
                    .doesNotThrowAnyException();
        }

    }

}
