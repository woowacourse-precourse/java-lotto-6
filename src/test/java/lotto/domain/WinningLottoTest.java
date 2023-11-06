package lotto.domain;

import static lotto.config.ErrorMessage.OVERLAPPED_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

	private WinningLotto winningLotto;
	private Exception exception;


	@Test
	@DisplayName("당첨번호, 보너스번호를 올바르게 반환하는지 테스트")
	void getWinningLotto() {
		String numbers = "1,2,3,4,5,6";
		String bonusNumber = "44";

		winningLotto = new WinningLotto(new WinningNumbers(numbers), new BonusNumber(bonusNumber));

		assertThat(winningLotto.getWinningNumbers().getWinningNumbers().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
		assertThat(winningLotto.getWinningNumbers()).isInstanceOf(WinningNumbers.class);

		assertThat(winningLotto.getBonusNumber().getBonusNumber()).isEqualTo(44);
		assertThat(winningLotto.getBonusNumber()).isInstanceOf(BonusNumber.class);
	}

	@Test
	@DisplayName("당첨 번호와 보너스 번호가 중복될 경우 IllegalArgumentException 이 발생한다.")
	void testValidate_DuplicationBonusNumber() {
		String numbers = "1,2,3,4,5,6";
		String bonusNumber = "6";

		exception = assertThrows(IllegalArgumentException.class, () -> winningLotto = new WinningLotto(new WinningNumbers(numbers), new BonusNumber(bonusNumber)));

		assertEquals(exception.getMessage(), OVERLAPPED_BONUS_NUMBER.getMessage());
	}
}