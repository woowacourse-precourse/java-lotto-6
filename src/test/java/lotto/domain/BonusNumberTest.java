package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.message.ErrorMessage;

public class BonusNumberTest {

	private Lotto answerLottoNumebers;

	@BeforeEach
	void setup() {
		answerLottoNumebers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
	}

	@DisplayName("보너스 번호가 당첨 로또 번호와 중복되면 예외가 발생한다.")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@ParameterizedTest
	void createBonusNumberDuplicatedNumber(int bonusNumber) {
		assertThatThrownBy(() -> new BonusNumber(answerLottoNumebers, bonusNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
	}

	@DisplayName("보너스 번호와 당첨 로또 번호가 중복이 아닐 경우 정상적으로 작동한다.")
	@ValueSource(ints = {10, 22, 33, 45})
	@ParameterizedTest
	void checkNomalOperation1(int bonusNumber) {
		new BonusNumber(answerLottoNumebers, bonusNumber);
	}

	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
	@ValueSource(ints = {0, 46, 47})
	@ParameterizedTest
	void createBonusNumberByNumberOutOfRange() {
		assertThatThrownBy(() -> new BonusNumber(answerLottoNumebers, 46))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
						.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
	}

	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER라면 정상적으로 작동한다.")
	@ValueSource(ints = {7, 12, 24, 45})
	@ParameterizedTest
	void checkNomalOperation2(int bonusNumber) {
		new BonusNumber(answerLottoNumebers, bonusNumber);
	}
}