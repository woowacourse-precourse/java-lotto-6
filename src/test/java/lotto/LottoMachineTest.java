package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest extends NsTest {

	private LottoMachine lottoMachine = new LottoMachine();

	@DisplayName("로또 구매 테스트")
	@Test
	void buyLottos() {
		assertRandomUniqueNumbersInRangeTest(
				() -> {
					Lottos lottos = lottoMachine.buyLottos(2000);
					lottos.print();
					assertThat(output()).contains(
							"2개를 구매했습니다.",
							"[1, 2, 3, 4, 5, 6]",
							"[7, 8, 9, 10, 11, 12]"
							);
				},
				List.of(1, 2, 3, 4, 5, 6),
				List.of(7, 8, 9, 10, 11, 12)
		);
	}

	@Override
	protected void runMain() {
	}
}