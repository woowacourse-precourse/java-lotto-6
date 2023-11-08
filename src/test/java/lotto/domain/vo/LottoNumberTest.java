package lotto.domain.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@DisplayName("범위(1~45)를 벗어난 숫자가 입력되면 예외가 발생한다.")
	@Test
	void valueOf() {
		//given
		int outRangedNumber = 55;
		//when
		assertThatThrownBy(() -> LottoNumber.valueOf(outRangedNumber))
				//then
				.isInstanceOf(LottoException.class);
	}
}