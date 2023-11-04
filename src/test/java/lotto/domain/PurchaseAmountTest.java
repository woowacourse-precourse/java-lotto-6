package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_PURCHASE_AMOUNT;
import static lotto.config.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.config.ErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

	private PurchaseAmount purchaseAmount;
	private Exception exception;

	@Test
	@DisplayName("구매금액을 올바르게 반환하는지 검증하는 테스트")
	void getPurchaseAmount() {
		String correct_PurchaseAmount = "2000";

		purchaseAmount = new PurchaseAmount(correct_PurchaseAmount);

		assertThat(purchaseAmount.getAmount()).isEqualTo(2000);
	}

	@Test
	@DisplayName("구매금액 입력시 공백을 입력할 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenBlank() {
		String type_blank = "";

		exception = assertThrows(IllegalArgumentException.class, () -> purchaseAmount = new PurchaseAmount(type_blank));

		assertEquals(exception.getMessage(), BLANK_PURCHASE_AMOUNT.getMessage());
	}

	@Test
	@DisplayName("구매금액이 null 일 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenNull() {
		String type_null = null;

		exception = assertThrows(IllegalArgumentException.class, () -> purchaseAmount = new PurchaseAmount(type_null));

		assertEquals(exception.getMessage(), BLANK_PURCHASE_AMOUNT.getMessage());
	}

	@Test
	@DisplayName("구매금액 입력시 숫자가 아닌 문자일 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenNonNumeric() {
		String type_string = "이천원";

		exception = assertThrows(IllegalArgumentException.class, () -> purchaseAmount = new PurchaseAmount(type_string));

		assertEquals(exception.getMessage(), NON_NUMERIC_PURCHASE_AMOUNT.getMessage());
	}

	@Test
	@DisplayName("구매금액 입력시 1,000원 단위가 아닐 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_WhenNotMultipleOfThousand() {
		String type_not_multiple_of_thousand = "1500";

		exception = assertThrows(IllegalArgumentException.class, () -> purchaseAmount = new PurchaseAmount(type_not_multiple_of_thousand));

		assertEquals(exception.getMessage(), INVALID_PURCHASE_AMOUNT.getMessage());
	}
}