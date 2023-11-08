package lotto;

import lotto.domain.validation.LottoPurchaseAmountValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottoNumberDomainTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 1000이하면 에러가 발생한다.")
    @Test
    void createLottoAmountByUnderThousand() {
        String invalidAmount = "-1000";
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(invalidAmount);
        assertThatThrownBy(lottoPurchaseAmountValidation::purchaseAmountValidation)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 1000단위가 아니라면 에러가 발생한다.")
    @Test
    void createLottoAmountIsAThousandUnits() {
        String invalidAmount = "1100";
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(invalidAmount);
        assertThatThrownBy(lottoPurchaseAmountValidation::purchaseAmountValidation)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 숫자가 아니라면 에러가 발생한다.")
    @Test
    void createLottoAmountIsConvertInteger() {
        String invalidAmount = "Thousand";
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(invalidAmount);
        assertThatThrownBy(lottoPurchaseAmountValidation::purchaseAmountValidation)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
