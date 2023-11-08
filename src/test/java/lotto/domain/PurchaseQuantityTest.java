package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseQuantityTest {

    @DisplayName("구매 금액 입력 - 정상")
    @Test
    void inputAmountAmountCorrect() {
        String inputAmount = "10000";

        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(inputAmount);
        assertEquals(10000, purchaseQuantity.getAmount());
    }

    @DisplayName("구매 금액 입력 - 문자 포함 입력 예외")
    @Test
    void inputAmountIncludeString() {
        String inputAmount = "10000A";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 문자 입력 예외")
    @Test
    void inputAmountOnlyString() {
        String inputAmount = "a";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 공백 포함 입력 예외")
    @Test
    void inputAmountIncludeSpace() {
        String inputAmount = "1000   ";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 공백 입력 예외")
    @Test
    void inputAmountOnlySpace() {
        String inputAmount = "  ";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 개행 입력 예외")
    @Test
    void inputAmountEnter() {
        String inputAmount = "\n";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 입력값 없음 예외")
    @Test
    void inputAmountEmpty() {
        String inputAmount = "";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 입력값 NULL 예외")
    @Test
    void inputAmountNULL() {
        String inputAmount = null;

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 최소 금액 미달 입력 예외")
    @Test
    void enterZero() {
        String inputAmount = "0";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 1000 단위 아닐 경우 예외 ")
    @Test
    void enterNotDividedByThousand() {
        String inputAmount = "1005";

        assertThatThrownBy(() -> new PurchaseQuantity(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력 - 로또 개수 확인")
    @Test
    void getNumberOfLottoPurchased() {
        String inputAmount = "10000";
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(inputAmount);

        assertEquals(10, purchaseQuantity.getLottoPurchases());
    }

}