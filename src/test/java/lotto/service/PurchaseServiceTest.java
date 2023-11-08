package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class PurchaseServiceTest {
	PurchaseService purchaseService = new PurchaseService();

	@Test
	@DisplayName("주어진 돈과 로또 가격에 맞게 로또를 구매한다.")
	void purchaseLotto() {
		// given
		var money = 10005;
		var amount = money / Lotto.PRICE;

		// when
		var lotto = purchaseService.purchaseLotto(money);

		// then
		assertThat(lotto.size()).isEqualTo(amount);
	}
}
