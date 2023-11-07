package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	@DisplayName("당첨 번호, 보너스 번호를 올바르게 반환하는지 테스트")
	void getWinningLotto() {
		String numbers = "1,2,3,4,5,6";
		String bonusNumber = "44";

		WinningLotto winningLotto = new WinningLotto(new WinningNumbers(numbers), new BonusNumber(bonusNumber));

		assertThat(winningLotto.getWinningNumbers().getWinningNumbers().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
		assertThat(winningLotto.getWinningNumbers()).isInstanceOf(WinningNumbers.class);

		assertThat(winningLotto.getBonusNumber().getBonusNumber()).isEqualTo(44);
		assertThat(winningLotto.getBonusNumber()).isInstanceOf(BonusNumber.class);
	}

	@Test
	@DisplayName("당첨 번호와 로또 번호의 일치하는 숫자를 올바르게 반환하는지 테스트")
	void calculateMatchCount() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,7,8,9");
		BonusNumber bonusNumber = new BonusNumber("7");
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

		int result = winningLotto.calculateMatchCount(lotto);

		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("로또 번호에 보너스 번호가 없을시 false 반환")
	void isBonusMatch_false() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,7,8,9");
		BonusNumber bonusNumber = new BonusNumber("7");
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

		boolean result = winningLotto.isBonusMatch(lotto);

		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("로또 번호에 보너스 번호가 있을시 true 반환")
	void isBonusMatch_true() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,8,9");
		BonusNumber bonusNumber = new BonusNumber("6");
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

		boolean result = winningLotto.isBonusMatch(lotto);

		assertThat(result).isTrue();
	}
}