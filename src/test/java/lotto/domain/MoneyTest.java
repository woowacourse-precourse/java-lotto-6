package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.message.ErrorMessage;

public class MoneyTest {

	@DisplayName("돈의 단위가 UNIT이 아니라면 예외가 발생한다.")
	@ValueSource(ints =  { 400, 1200, 1001 })
	@ParameterizedTest
	void createMoneyByWrongMoneyUnit(int number) {
		assertThatThrownBy(() -> new Money(300))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.MONEY_UNIT_ERROR.getFormattedMessage(Money.UNIT));
	}

	@DisplayName("돈의 단위가 UNIT이라면 정상적으로 작동한다.")
	@ValueSource(ints =  { 1000, 12000, 4000 })
	@ParameterizedTest
	void checkNomalOperation1() {
		new Money(1000);
	}
	
	@DisplayName("돈이 0이하라면 예외가 발생한다.")
	@ValueSource(ints =  { 0, -10, -100 })
	@ParameterizedTest
	void createMoneyByPositiveNumber(int number) {
		assertThatThrownBy(() -> new Money(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.ZERO_OR_NEGATIVE_NUMBER_ERROR.getMessage());
	}

	@DisplayName("돈이 0보다 크다면 정상적으로 작동한다.")
	@ValueSource(ints =  { 1000, 2000, 3000 })
	@ParameterizedTest
	void checkNomalOperation2() {
		new Money(1000);
	}
}
