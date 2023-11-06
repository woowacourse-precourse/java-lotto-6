package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

	@DisplayName("로또 구매 금액이 정수형이 아니라면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"test","!@#","12@12"})
	public void test(String input) {
		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
