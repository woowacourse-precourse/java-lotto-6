package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoCalculatorTest {
	@DisplayName("당첨 번호와 로또 번호를 비교해 같은 숫자 카운트")
	@Test
	public void CountMatchingNumbers() {
		//given
		String lotto = "1,2,3,4,5,6";
		String bonusNumber = "7";
		int expected = 4;

		WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
		Lotto purchaseLotto = new Lotto("1,2,8,4,5,9");
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();

		// when
		long matchCount = winningLottoCalculator.getMatchCount(purchaseLotto, winningLotto);

		//then
		Assertions.assertThat(matchCount).isEqualTo(expected);
	}
}
