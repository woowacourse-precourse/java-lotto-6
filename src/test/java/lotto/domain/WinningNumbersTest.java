package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.exception.LottoException;

public class WinningNumbersTest {
	@Test
	void 당첨번호를_입력받아_객체를_생성한다() {
		String numbers = "1,2,3,4,5,6";
		WinningNumbers lottoWinningNumbers = new WinningNumbers(numbers);

		assertThat(lottoWinningNumbers.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
	}

	@Test
	void 당첨번호가_숫자가_아니면_예외를_던진다() {
		String notNumbers = "abc,abc";

		assertThatThrownBy(() -> new WinningNumbers(notNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨번호가_로또번호가_아니면_예외를_던진다() {
		String notLottos = "0,46";

		assertThatThrownBy(() -> new WinningNumbers(notLottos))
			.isExactlyInstanceOf(LottoException.class);
	}

	@Test
	void 당첨된_로또번호_숫자를_반환한다() {
		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
		Lotto lotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
		int expected = 6;

		assertThat(winningNumbers.compareWith(lotto)).isEqualTo(expected);
	}
}
