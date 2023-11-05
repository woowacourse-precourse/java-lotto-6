package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.manager.Exception;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입금액_검증")
public class ValidatePurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 18000})
    @DisplayName("정상처리")
    void 구입금액_검증_정상처리(int purchaseAmount) {
        assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1, -1000})
    @DisplayName("[예외처리] 1000원 미만인 구입금액")
    void 구입금액_검증_1000미만_예외처리(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(Exception.PURCHASE_AMOUNT_OUT_OF_RANGE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 15001, 1800})
    @DisplayName("[예외처리] 1000원 단위가 아닌 구입금액")
    void 구입금액_검증_1000원_단위_아님_예외처리(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(Exception.PURCHASE_AMOUNT_WRONG_UNIT.getErrorMessage());
    }
}
