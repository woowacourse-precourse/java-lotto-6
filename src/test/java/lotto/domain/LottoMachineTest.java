package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	private PurchaseAmount purchaseAmount;
	private final LottoMachine lottoMachine = new LottoMachine();

	@Test
	@DisplayName("규정된 구매금액을 입력하면 금액에 따른 로또 생성 테스트")
	void createLottoTicket() {
		purchaseAmount = new PurchaseAmount("5000");

		assertThat(lottoMachine.purchaseLotto(purchaseAmount)).isInstanceOf(LottoPlayer.class);
		assertThat(lottoMachine.purchaseLotto(purchaseAmount).getPurchasedLottos().get(0)).isInstanceOf(Lotto.class);
		assertThat(lottoMachine.purchaseLotto(purchaseAmount).getPurchasedLottos().size()).isEqualTo(5);
	}
}