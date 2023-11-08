package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountValidationTest {
    private PurchaseAmountValidation purchaseAmountValidation;

    @BeforeEach
    void setUp() {
        purchaseAmountValidation = new PurchaseAmountValidation();
    }

    @DisplayName("구입금액이 int의 범위를 벗어나면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2200000000", "-3000000000"})
    void enterNumberOutOfIntRange(String input) {
        assertThatThrownBy(() -> purchaseAmountValidation.validateCheckRangeOfPurchaseAmountInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액을 음수로 입력하면 에러가 발생한다.")
    @Test
    void enterNegativeNumber() {
        assertThatThrownBy(() -> purchaseAmountValidation.validatePurchaseAmountIsPositive(-123000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 21억(2,100,000,000)보다 크면 에러가 발생한다.")
    @Test
    void enterNumberGreaterThanMaxNumber() {
        assertThatThrownBy(() -> purchaseAmountValidation.validatePurchaseAmountOutOfRange(2100000001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원 단위가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1230, 12300, 123001, 10001})
    void enterNonMultipleOf1000Number(Integer input) {
        assertThatThrownBy(() -> purchaseAmountValidation.validatePurchaseAmountUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액을 입력하면 숫자로 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"10000", "100000000"})
    void generatePurchaseAmount(String input) {
        int answer = Integer.parseInt(input);
        int result = purchaseAmountValidation.validatePurchaseAmount(input);

        assertThat(result).isEqualTo(answer);
    }
}