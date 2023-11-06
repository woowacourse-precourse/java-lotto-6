package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseTimeMakerTest {

	@DisplayName("구매 개수가 정확히 계산되는지 확인")
	@Test
	void makePurchaseTimeTest() {
		//given
		String inputPurchaseAmount = "8000";

		//when
		int actualPurchaseTime = PurchaseTimeMaker.makePurchaseTime(inputPurchaseAmount);

		//then
		int expectedPurchaseTime = 8;
		assertEquals(expectedPurchaseTime, actualPurchaseTime);
	}

	@DisplayName("구매 금액이 숫자가 아닐 경우 오류가 발생하는지 확인")
	@Test
	void inputPurchaseAmountWithString() {
		//given
		String inputPurchaseAmount = "8000j";

		//when, then
		assertThatThrownBy(() -> PurchaseTimeMaker.makePurchaseTime(inputPurchaseAmount))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매 금액이 1000원 단위가 아닐 경우 오류가 발생하는지 확인")
	@ParameterizedTest
	//given
	@ValueSource(strings = {"0", "500", "1700", "8765", "12345"})
	void inputPurchaseAmountDifferentUnit(String element) {

		//when, then
		assertThatThrownBy(() -> PurchaseTimeMaker.makePurchaseTime(element))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
