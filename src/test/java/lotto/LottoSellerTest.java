package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

	@Test
	@DisplayName("금액 / 1000 만큼 갯수의 로또를 생성하여 리스트로 반환한다.")
	void test01() {
		final var lottoSeller = new LottoSeller();
		final var buyLottoAmount = 10000;
		final var lottos = lottoSeller.sellLotto(buyLottoAmount);
		assertThat(lottos)
			.hasSize(10);
	}
}
