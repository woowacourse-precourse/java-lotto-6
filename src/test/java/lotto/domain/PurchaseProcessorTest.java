package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseProcessorTest {


    @DisplayName("올바른 가격으로 로또 수량 계산")
    @Test
    void validPrice() {
        PurchaseProcessor purchaseProcessor = new PurchaseProcessor("3000");
        assertThat(purchaseProcessor.getLottoCount()).isEqualTo(3);
    }

    @DisplayName("입력 가격이 숫자 형식이 아닐 경우 예외 발생")
    @Test
    void invalidPriceFormat() {
        assertThatThrownBy(() -> new PurchaseProcessor("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NUMBER.getMessage());
    }

}

