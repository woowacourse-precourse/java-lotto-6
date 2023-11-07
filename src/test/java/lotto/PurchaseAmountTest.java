package lotto;

import lotto.domain.ExceptionMessage;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @Nested
    @DisplayName("Success")
    class Success {
        @DisplayName("쉼표(,)가 포함된 구매 금액")
        @Test
        public void testPurchaseAmountWithCommas() {
            String inputAmount = "1,000";
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
            int expected = 1000;

            assertEquals(expected, purchaseAmount.getAmount());
        }

        @DisplayName("띄어쓰기가 포함된 구매 금액")
        @Test
        public void testPurchaseAmountWithSpace() {
            String inputAmount = "  2000  ";
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
            int expected = 2000;

            assertEquals(expected, purchaseAmount.getAmount());
        }

        @DisplayName("입력된 구매 금액으로 로또 개수 반환")
        @Test
        public void calculateLottoCountFromPurchaseAmount() {
            String inputAmount = "5,000";
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
            int expected = 5;

            assertEquals(expected, purchaseAmount.getLottoCount());
        }
    }

    @Nested
    @DisplayName("Success")
    class Failure {
        @Test
        @DisplayName("빈 값 입력 시, 에러 처리")
        void testValidateEmptyInput() {
            String inputAmount = "";

            assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NULL_INPUT.getMessage());
        }

        @Test
        @DisplayName("숫자 형식이 아닌 값 입력 시, 에러 처리")
        void testValidateNumericInput() {
            String inputAmount = "1a";

            assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER.getMessage());
        }

        @Test
        @DisplayName("1,000으로 나누어 떨어지지 않는 값 입력 시, 에러 처리")
        void testValidateDivisibleByThousand() {
            String inputAmount = "1200";

            assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}