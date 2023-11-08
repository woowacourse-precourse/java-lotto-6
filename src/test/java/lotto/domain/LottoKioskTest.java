package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoKioskTest {

	@DisplayName("주입된 Money가 로또 가격에 나누어지지 않은 값이면 예외가 발생한다.")
	@Test
	void validAmount() {
		//given
		int invalidMoney = 500;
		//when
		assertThatThrownBy(() -> new LottoKiosk(invalidMoney))
				//then
				.isInstanceOf(LottoException.class);
	}

	@DisplayName("주입된 Money에 맞는 로또가 생성되어야 한다.")
	@Test
	void perchaseLotto() {
		//given
		int Money = 5000;
		int expectedLottoAmout = 5;
		//when
		Lotto lotto = new LottoKiosk(Money).perchaseLotto();
		//then
		Assertions.assertThat(lotto.getLotto().size()).isEqualTo(expectedLottoAmout);
	}
}