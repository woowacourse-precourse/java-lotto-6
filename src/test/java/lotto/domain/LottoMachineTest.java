package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

	@DisplayName("LottoMachine 생성 시 보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
	@Test
	void createLottoMachineByDuplicateBonusNumber() {
		assertThatThrownBy(() -> new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("LottoMachine 생성 시 보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
	@Test
	void createLottoMachineByWrongBonusNumber() {
		assertThatThrownBy(() -> new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 58))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("LottoMachine의 sellLotto 호출 시 구입금액이 1000 미만이거나 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
	@Test
	void sellLottoByWrongPrice() {
		assertThatThrownBy(() -> LottoMachine.sellLotto(9999))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
