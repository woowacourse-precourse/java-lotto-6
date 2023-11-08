package lotto.domain.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@DisplayName("음수의 값이 나오면 에러가 발생한다.")
	@Test
	void money() {
		//given
		int negativeValue = -1000;
		//when
		assertThatThrownBy(() -> new Money(negativeValue))
				//then
				.isInstanceOf(LottoException.class);
	}
}