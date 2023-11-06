package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	@DisplayName("당첨번호, 보너스번호를 올바르게 반환하는지 테스트")
	void getWinningLotto() {
		String numbers = "1,2,3,4,5,6";
		String bonusNumber = "44";

		WinningLotto winningLotto = new WinningLotto(new WinningNumbers(numbers), new BonusNumber(bonusNumber));

		assertThat(winningLotto.getWinningNumbers().getWinningNumbers().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
		assertThat(winningLotto.getWinningNumbers()).isInstanceOf(WinningNumbers.class);

		assertThat(winningLotto.getBonusNumber().getBonusNumber()).isEqualTo(44);
		assertThat(winningLotto.getBonusNumber()).isInstanceOf(BonusNumber.class);
	}
}