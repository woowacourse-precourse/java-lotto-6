package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputPurchaseAmountValidatorTest {

    private InputPurchaseAmountValidator inputPurchaseAmountValidator;

    @BeforeEach
    public void init() {
        inputPurchaseAmountValidator = new InputPurchaseAmountValidator();
    }

    @DisplayName("구매금액이 숫자가 아닐때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "123bb", "1##$1"})
    void 숫자가_아닐때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputPurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1,000원 단위가 아닐때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"100", "12345", "1400"})
    void 구매금액이_1000원_단위가_아닐때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputPurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 2,147,483,647원 보다 클때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2200000000", "300000000000", "9000000000000"})
    void 구매금액이_2147483647원_보다_클때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputPurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
