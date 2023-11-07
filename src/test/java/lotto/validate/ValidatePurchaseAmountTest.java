package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.domain.Amount;
import lotto.domain.User;
import lotto.utils.Validation;
import lotto.constants.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatePurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 20000, 50000})
    @DisplayName("구입_금액_검증_통과")
    void 구입_금액_검증_통과(int purchaseAmount) {
        assertThatCode(() -> Validation.validatePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 2001, 5001, 10001, 20001, 50001})
    @DisplayName("구입_금액_검증_실패_1000원_단위")
    void 구입_금액_검증_실패_1000원_단위(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(ExceptionMessages.INPUT_MULTIPLE_NUMBER.getMessage(1_000));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, -10000, -100000})
    @DisplayName("구입_금액_검증_실패_음수")
    void 구입_금액_검증_실패_음수(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(ExceptionMessages.NUMBER_IN_RANGE.getMessage(1_000, 100_000));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 500, 899, 999})
    @DisplayName("구입_금액_검증_실패_1000원_미만")
    void 구입_금액_검증_실패_1000원_미만(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(ExceptionMessages.NUMBER_IN_RANGE.getMessage(1_000, 100_000));
    }

    @ParameterizedTest
    @ValueSource(ints = {100001, 200000, 500000, 1000000, 2000000, 5000000})
    @DisplayName("구입_금액_검증_실패_100000원_초과")
    void 구입_금액_검증_실패_100000원_초과(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.validatePurchaseAmount(purchaseAmount))
                .withMessageContaining(ExceptionMessages.NUMBER_IN_RANGE.getMessage(1_000, 100_000));
    }
}
