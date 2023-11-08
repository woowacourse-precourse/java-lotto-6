package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest extends NsTest {

	private List<Lotto> lotto = List.of(
			Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
			Lotto.of(List.of(1, 2, 3, 10, 11, 12)),
			Lotto.of(List.of(13, 14, 15, 16, 17, 18))
	);

	@DisplayName("로또 목록 출력 테스트")
	@Test
	void printLottos() {
		Lottos lottos = Lottos.of(lotto);
		lottos.print();
		assertThat(output()).contains(
				"3개를 구매했습니다.",
				"[1, 2, 3, 4, 5, 6]",
				"[1, 2, 3, 10, 11, 12]",
				"[13, 14, 15, 16, 17, 18]"
		);
	}

	@DisplayName("로또 목록 체점 테스트")
	@Test
	void matchLottoByLotto() {
		Lottos lottos = Lottos.of(lotto);
		Lotto answerLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		Integer bonusNumber = 7;
		LottoResults lottoResults = lottos.matchLotto(answerLotto, bonusNumber);
		assertThat(lottoResults).isNotNull();
	}

	@Override
	protected void runMain() {

	}
}