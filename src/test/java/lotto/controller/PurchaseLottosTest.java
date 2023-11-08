package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.model.Lottos;

class PurchaseLottosTest {

	@Test
	void 구매한_복권의_금액에_맞춰_복권_생성() {
		
		PurchaseLottos purchaseLottos = new PurchaseLottos();
		Lottos lottos = new Lottos();
		
		purchaseLottos.generated(lottos, 8000);
		
		int lotto_count = lottos.getSize();
		
		assertThat(lotto_count).isEqualTo(8);
	}
}
