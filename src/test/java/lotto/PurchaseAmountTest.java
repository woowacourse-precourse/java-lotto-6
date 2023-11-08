package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("빈 문자열로 PurchaseAmount를 생성하면 예외가 발생한다.")
    @Test
    void createPurchaseAmountWithEmptyString() {
        assertThatThrownBy(() -> PurchaseAmount.creat(""))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.EMPTY.getMessage());
    }

    @DisplayName("숫자가 아닌 문자열로 PurchaseAmount를 생성하면 예외가 발생한다.")
    @Test
    void createPurchaseAmountWithNonNumericString() {
        assertThatThrownBy(() -> PurchaseAmount.creat("abc"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생해야 한다.")
    @Test
    void createPurchaseAmountWithInvalidAmount() {
        String invalidAmount = "1500"; // 1000원 단위가 아닌 금액

        assertThatThrownBy(() -> PurchaseAmount.creat(invalidAmount))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.IS_NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    @DisplayName("구입 금액이 유효한 경우 PurchaseAmount 객체가 생성되어야 한다.")
    @Test
    void createValidPurchaseAmount() {
        String validAmount = "3000"; // 1000원 단위인 금액

        PurchaseAmount purchaseAmount = PurchaseAmount.creat(validAmount);

        assertThat(purchaseAmount).isNotNull();
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(3000);
    }
}
