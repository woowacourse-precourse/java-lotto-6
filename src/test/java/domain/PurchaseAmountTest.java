package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName    : domain
 * fileName       : PurchaseAmountTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class PurchaseAmountTest {

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 정상으로 금액을 입력한 경우를 검증합니다.")
    @Test
    void enterNormalAmount() {
        String inputAmount = "10000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        assertThat(purchaseAmount.getAmount()).isEqualTo(10000);
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 문자만 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void enterString() {
        String inputAmount = "abcde";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 숫자와 문자를 함께 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void enterNumberWithString() {
        String inputAmount = "123abc";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 띄어쓰기만 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void enterSpace() {
        String inputAmount = "   ";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - \n 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void enterNewLine() {
        String inputAmount = "\n";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 어떠한 값도 입력하지 않은 경우, 예외를 발생시킵니다.")
    @Test
    void enterNothing() {
        String inputAmount = "";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 0을 입력할 경우, 예외를 발생시킵니다.")
    @Test
    void enterZero() {
        String inputAmount = "0";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.getMessage());
    }

    @DisplayName("로또 구매 금액을 올바르게 입력했는지 검증합니다. - 1000으로 나누어떨어지지 않는 값을 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void enterNotDividedByThousand() {
        String inputAmount = "12345";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.getMessage());
    }

    @DisplayName("로또 구매 금액에 따라 로또 구매 개수가 올바르게 반환되는지 검증합니다.")
    @Test
    void getnumberOfLottoPurchased(){
        String inputAmount = "14000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        assertThat(purchaseAmount.getNumberOfLottoPurchased()).isEqualTo(14);
    }
}
