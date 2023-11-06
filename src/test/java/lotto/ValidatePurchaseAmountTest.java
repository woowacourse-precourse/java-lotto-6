package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.manager.LottoException;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입 금액 검증")
public class ValidatePurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "9900000"})
    @DisplayName("[정상처리] 구입 금액을 검증한다.")
    void 구입금액_검증_정상처리(String purchaseAmount) {
        Amount amount = new Amount(purchaseAmount);
        assertThatCode(() -> Validator.validatePurchaseAmount(amount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "0", "-1", "-1000"})
    @DisplayName("[예외처리] 구입 금액이 1000원 미만이면 예외가 발생한다.")
    void 구입금액_검증_1000미만_예외처리(String purchaseAmount) {
        Amount amount = new Amount(purchaseAmount);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validatePurchaseAmount(amount))
                .withMessageContaining(LottoException.PURCHASE_AMOUNT_OUT_OF_RANGE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "15001", "1800"})
    @DisplayName("[예외처리] 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 구입금액_검증_1000원_단위_아님_예외처리(String purchaseAmount) {
        Amount amount = new Amount(purchaseAmount);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validatePurchaseAmount(amount))
                .withMessageContaining(LottoException.PURCHASE_AMOUNT_WRONG_UNIT.getErrorMessage());
    }
}
