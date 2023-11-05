package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottoOrderTest {

    @DisplayName("구입 가격이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoOrderByNonUnitOf1000Won() {
        // given
        final long purchasePrice = 1004;
        PurchaseLotto mockPurchaseLotto = Mockito.mock(PurchaseLotto.class);

        // when & then
        assertThatThrownBy(() -> new LottoOrder(purchasePrice, mockPurchaseLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_PRICE.getDesc());
    }

    @DisplayName("구입 가격이 0원일 경우 예외가 발생한다.")
    @Test
    void createLottoOrderBy0Won() {
        // given
        final long purchasePrice = 0;
        PurchaseLotto mockPurchaseLotto = Mockito.mock(PurchaseLotto.class);

        // when & then
        assertThatThrownBy(() -> new LottoOrder(purchasePrice, mockPurchaseLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_PRICE.getDesc());
    }

}