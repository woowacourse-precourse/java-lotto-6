package lotto.dto.requset;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {
	@DisplayName("빈값이면 예외가 발생한다.")
	@Test
	void createPriceByEmpty() {
		assertThatThrownBy(() -> new Price(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아니면 예외가 발생한다.")
	@Test
	void createPriceByNumber() {
		assertThatThrownBy(() -> new Price("문자"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1000의배수가 아니면 예외가 발생한다.")
	@Test
	void createPriceByMultiple() {
		assertThatThrownBy(() -> new Price("1200"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("성공적인 테스트")
	@Test
	void createPriceBySuccess() {
		assertThatCode(() -> new Price("2000"))
			.doesNotThrowAnyException();
	}






}