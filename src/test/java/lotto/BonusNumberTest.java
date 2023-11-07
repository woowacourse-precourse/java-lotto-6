package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import lotto.enums.LottoError;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BonusNumberTest {

	@Test
	void 보너스_숫자가_1에서45_범위를_벗어나면_예외가_발생한다() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		String errorMessage = LottoError.INVALID_RANGE_INPUT.getErrorDescription();
		assertThatThrownBy(() -> new BonusNumber(0, lotto))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(errorMessage);
	}

	@Test
	void 보너스_숫자가_이미_로또번호에_있다면_예외가_발생한다() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		String errorMessage = LottoError.INVALID_BONUS_NUMBER.getErrorDescription();
		assertThatThrownBy(() -> new BonusNumber(1, lotto))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(errorMessage);
	}

	@Test
	void 보너스_숫자_정상_생성(){
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		assertThat(7).isEqualTo(new BonusNumber(7, lotto).getBonusNumber());
	}
}