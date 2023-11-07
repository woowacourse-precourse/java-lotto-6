package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.exception.LottoException;

public class LottoWinningNumbersTest {
	@Test
	void 당첨번호를_입력받아_객체를_생성한다() {
		String numbers = "1,2,3,4,5,6";
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(numbers);

		assertThat(lottoWinningNumbers.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
	}

	@Test
	void 당첨번호가_숫자가_아니면_예외를_던진다() {
		String notNumbers = "abc,abc";

		assertThatThrownBy(() -> new LottoWinningNumbers(notNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨번호가_로또번호가_아니면_예외를_던진다() {
		String notLottos = "0,46";

		assertThatThrownBy(() -> new LottoWinningNumbers(notLottos))
			.isExactlyInstanceOf(LottoException.class);
	}
}
