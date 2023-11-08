package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.LottoException;
import lotto.util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

	@DisplayName("당첨 번호 형식에 맞지 않은 입력값에 대해 예외를 발생한다.")
	@Test
	void parseWinningNumber() {
		//given
		String invalidInput = "1,2,3,4,e,5";
		//when
		assertThatThrownBy(() -> Parser.parseWinningNumber(invalidInput))
				//then
				.isInstanceOf(LottoException.class);
	}

	@DisplayName("숫자가 아닌 입력값에 대해 예외를 발생한다.")
	@Test
	void parseInteger() {
		//given
		String invalidInput = "1000e";
		//when
		assertThatThrownBy(() -> Parser.parseInteger(invalidInput))
				//then
				.isInstanceOf(LottoException.class);
	}
}