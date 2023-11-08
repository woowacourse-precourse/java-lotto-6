package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

	@DisplayName("당첨 번호와 겹치는 보너스 번호가 있으면 예외가 발생한다.")
	@Test
	void duplicateBonusNumber() {
		//given
		LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.valueOf(1);
		//when
		assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
				//then
				.isInstanceOf(LottoException.class);
	}
}