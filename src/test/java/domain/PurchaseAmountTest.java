package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

	@DisplayName("로또 구매 금액이 정수형이 아니라면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"test", "!@#", "12@12", " ", ""})
	public void LottoPurchaseAmountWithNonIntegerValue(String input) {
		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매 금액이 0보다 큰 값인지 검증 아니라면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void LottoPurchaseAmountGreaterThanZero(String input) {
		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매 금액이 1000 단위인지 검증 아니라면 예외 발생")
	@Test
	public void LottoPurchaseAmountInThousandUnits() {
		// given
		String input = "12314";

		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매 금액에 따라 로또가 몇개인지 체크")
	@Test
	public void LottoPurchaseCountForGivenPurchaseAmount() {
		//given
		String input = "3000";
		int excepted = 3;

		// when
		PurchaseAmount purchaseAmount = new PurchaseAmount(input);
		int lottoPurchaseCount = purchaseAmount.getLottoPurchaseCount();

		//then
		Assertions.assertThat(lottoPurchaseCount).isEqualTo(excepted);
	}
}
