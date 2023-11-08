package lotto.model;

import static lotto.Constants.Constants.LOTTO_PRICE;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    private final LottoShop lottoShop = new LottoShop();

    @DisplayName("로또 가격 단위로 돈을 지불하지 않는다면 예외가 발생한다")
    @Test
    void purchaseAmountIsNotPriceUnit() {
        final int purchaseAmount = LOTTO_PRICE + LOTTO_PRICE / 2;

        assertThatThrownBy(() -> lottoShop.purchase(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_PRICE_UNIT.getMessage());
    }

    @DisplayName("지불한 돈이 양수가 아니라면 예외가 발생한다")
    @ValueSource(ints = {0, -1000})
    void purchaseAmountIsNotPositive(final int purchaseAmount) {
        assertThatThrownBy(() -> lottoShop.purchase(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
    }

    @DisplayName("구매 금액에 맞춰 로또들을 발행한다")
    @Test
    void generateLottsFromPurchaseAmount() {
        final int lottoCount = 3;
        final int purchaseAmount = LOTTO_PRICE * lottoCount;

        final List<Lotto> lottos = lottoShop.purchase(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

}