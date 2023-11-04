package lotto.domain;

import java.util.List;

public class LottoPlayer {

	private final List<Lotto> purchasedLottos;
	private long totalPrize;
	private double returnRate;

	public LottoPlayer(List<Lotto> purchasedLottos) {
		this.purchasedLottos = purchasedLottos;
	}

	public List<Lotto> getPurchasedLottos() {
		return purchasedLottos;
	}
}