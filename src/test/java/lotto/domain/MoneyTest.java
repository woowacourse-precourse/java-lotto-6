package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.message.ErrorMessage;

public class MoneyTest {

	@DisplayName("돈의 단위가 UNIT이 아니라면 예외가 발생한다.")
	@Test
	void createMoneyByWrongMoneyUnit() {
		assertThatThrownBy(() -> new Money(1200))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.MONEY_UNIT_ERROR.getForMatMessage(Money.UNIT));
	}

	@DisplayName("돈의 단위가 UNIT이라면 정상적으로 작동한다.")
	@Test
	void checkNomalOperation1() {
		new Money(1000);
	}
}
