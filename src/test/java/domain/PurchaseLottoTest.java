package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseLottoTest {
	@DisplayName("로또 구매 금액에 따른 로또 생성")
	@ParameterizedTest
	@ValueSource(strings = {"3000", "12000", "100000"})
	public void CreateLottosForPurchaseAmount(String input) {
		//given
		PurchaseAmount purchaseAmount = new PurchaseAmount(input);
		int expected = purchaseAmount.getLottoPurchaseCount();

		// when
		PurchaseLotto purchaseLotto = new PurchaseLotto(purchaseAmount);
		List<Lotto> lottos = purchaseLotto.getLottos();

		//then
		Assertions.assertThat(lottos.size()).isEqualTo(expected);
	}
}
