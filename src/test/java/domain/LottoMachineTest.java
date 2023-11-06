package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@DisplayName("랜덤 로또 번호 Lotto를 통해 유효성 검사")
	@Test
	public void createLottoWithRandomNumbers() {
		//given
		LottoMachine lottoMachine = new LottoMachine();

		// when
		Lotto lotto = new Lotto(lottoMachine.getRandomNumbers());

		// then
		Assertions.assertThat(lotto.getNumbers()).isEqualTo(lottoMachine.getRandomNumbers());
	}
}
