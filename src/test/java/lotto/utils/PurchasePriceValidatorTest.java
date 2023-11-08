package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceValidatorTest {

    @DisplayName("구매금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void 구입금액이_문자이면_안된다() {
        String purchasePrice = "문자";
        assertThatThrownBy(() -> PurchasePriceValidator.validIsInt(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void 구입금액은_1000의_배수가_아니면_안된다() {
        int purchasePrice = 1001;
        assertThatThrownBy(() -> PurchasePriceValidator.validIsMultiplesOfThousand(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
