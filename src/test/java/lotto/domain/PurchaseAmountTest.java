package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("입력 받은 금액이 1000원으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateIsDivideByLottoPrice() {
        //given
        int inputPrice = 14001;
        //when
        //then
        assertThatThrownBy(() -> {
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputPrice);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 로또 구입 금액이 로또 1장의 가격으로 나누어 떨어지지 않습니다.");
    }
}