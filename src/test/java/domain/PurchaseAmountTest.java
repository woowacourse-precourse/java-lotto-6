package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
}
