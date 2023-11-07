package lotto.domain;

import java.util.List;

public class LottoPlayer {

	private final List<Lotto> lottos;
	private final PurchaseAmount purchaseAmount;

	public LottoPlayer(List<Lotto> lottos, PurchaseAmount purchaseAmount) {
		this.lottos = lottos;
		this.purchaseAmount = purchaseAmount;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public PurchaseAmount getPurchaseAmount() {
		return purchaseAmount;
	}
}