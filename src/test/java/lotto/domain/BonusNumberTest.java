package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.message.ErrorMessage;

public class BonusNumberTest {

	private Lotto answerLottoNumebers;

	@BeforeEach
	void setup() {
		answerLottoNumebers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
	}

	@DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
	@Test
	void createAnswerLottoByDuplicatedBonusNumber() {
		assertThatThrownBy(() -> new BonusNumber(answerLottoNumebers, 5))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
	}

	@DisplayName("보너스 번호와 로또 번호가 중복이 아닐 경우 정상적으로 작동한다.")
	@Test
	void checkNomalOperation1() {
		new BonusNumber(answerLottoNumebers, 7);
	}

	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
	@Test
	void createAnswerLottoByBonusNumberOutOfRange() {
		assertThatThrownBy(() -> new BonusNumber(answerLottoNumebers, 46))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
						.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
	}

	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER라면 정상적으로 작동한다.")
	@Test
	void checkNomalOperation2() {
		new BonusNumber(answerLottoNumebers, 45);
	}
}
