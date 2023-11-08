package lotto.domain;

import lotto.dto.RequestLottos;
import lotto.util.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또 생성기")
class LottoMachineTest {

	LottoMachine lottoMachine;
	NumberGenerator numberGenerator;
	Cash cash;

	@BeforeEach
	void setUp() {
		numberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
		cash = Cash.create(1000, 0);
		lottoMachine = LottoMachine.create(numberGenerator, cash);
	}

	@DisplayName("로또 구매 기능 성공 테스트")
	@Test
	void purchaseLottosSuccessTest() {
		final Lotto expected = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
		final RequestLottos requestLottos = lottoMachine.purchaseLottos();
		final List<Lotto> lottoDummy = requestLottos.createLottoDummy();
		assertThat(lottoDummy.get(0)
			.equals(expected))
			.isTrue();
	}


}