package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessage;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입 금액 검증 테스트")
class PurchaseAmountTest {

    @DisplayName("입력 값 검증")
    @Nested
    class ValidatorTest {

        @DisplayName("빈 값 입력 시 예외가 발생한다.")
        @ParameterizedTest(name = "구매 금액=\"{0}\"")
        @ValueSource(strings = {"", " ", ","})
        void inputNull(String amount) {
            assertThatThrownBy(() -> new PurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_NULL_INPUT.getMessage());
        }

        @DisplayName("양의 정수가 아닐 시 예외가 발생한다.")
        @ParameterizedTest(name = "구매 금액=\"{0}\"")
        @ValueSource(strings = {"-1", "0"})
        void inputNotExceedZero(String amount) {
            assertThatThrownBy(() -> new PurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_ZERO.getMessage());
        }

        @DisplayName("숫자가 아닐 시 예외가 발생한다.")
        @ParameterizedTest(name = "구매 금액=\"{0}\"")
        @ValueSource(strings = {"aaa", "."})
        void inputNotDigit(String amount) {
            assertThatThrownBy(() -> new PurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_NOT_DIGIT.getMessage());
        }

        @DisplayName("쉼표(,)를 포함하여 입력하면 정상 처리된다.")
        @Test
        void inputSeparator() {
            PurchaseAmount purchaseAmount = new PurchaseAmount("1,000");
            assertThat(purchaseAmount.getAmount()).isEqualTo(1000);
        }

        @DisplayName("1,000원 단위로 나누어 떨어지지 않을 시 예외가 발생한다.")
        @ParameterizedTest(name = "구매 금액=\"{0}\"")
        @ValueSource(strings = {"2,500", "3,100"})
        void inputWrongUnit(String amount) {
            assertThatThrownBy(() -> new PurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_WRONG_UNIT_INPUT.getMessage());
        }
    }

    @DisplayName("PurchaseAmount 필드 검증")
    @Test
    void createPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        assertAll(
                () -> assertThat(purchaseAmount.getAmount()).isEqualTo(1000),
                () -> assertThat(purchaseAmount.getNumberOfLotto()).isEqualTo(1)
        );
    }
}
