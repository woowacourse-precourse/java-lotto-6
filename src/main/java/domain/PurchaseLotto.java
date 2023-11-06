package domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
	private final List<Lotto> lottos = new ArrayList<>();

	public PurchaseLotto(PurchaseAmount purchaseAmount) {
		generateLottosForPurchaseCount(purchaseAmount.getLottoPurchaseCount());
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	private void generateLottosForPurchaseCount(int lottoPurchaseCount) {
		for (int i = 0; i < lottoPurchaseCount; i++) {
			this.lottos.add(generateLotto());
		}
	}

	private Lotto generateLotto() {
		return new Lotto(new LottoMachine().getRandomNumbers());
	}

}
