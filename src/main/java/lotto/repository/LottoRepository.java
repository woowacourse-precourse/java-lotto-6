package lotto.repository;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class LottoRepository {
	private long price;
	private List<Lotto> lottos;
	private WinningResult winningResult;
	private int[] statistics;

	public void savePrice(long price) {
		this.price = price;
	}

	public long getPrice() {
		return this.price;
	}

	public void saveLottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> findAllLottos() {
		return this.lottos;
	}

	public void saveWinningResult(WinningResult winningResult) {
		this.winningResult = winningResult;
	}

	public WinningResult getWinningResult() {
		return winningResult;
	}

	public void saveStatistics(int[] rankCounts) {
		this.statistics = rankCounts;
	}

	public int[] getStatistics() {
		return statistics;
	}
}
