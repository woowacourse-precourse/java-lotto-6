package lotto.service;

import static lotto.constant.LottoConstant.*;
import static lotto.utility.LottoGenerator.*;

import java.util.ArrayList;
import java.util.List;

import lotto.constant.Grade;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.repository.LottoRepository;

public class LottoService {
	private final LottoRepository lottoRepository;

	public LottoService() {
		lottoRepository = new LottoRepository();
	}

	public void savePrice(long price) {
		lottoRepository.savePrice(price);
	}

	public void purchaseLottos() {
		long count = lottoRepository.getPrice() / LOTTO_PRICE.getValue();
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> numbers = getLottoNumbers();
			lottos.add(new Lotto(numbers));
		}

		lottoRepository.saveLottos(lottos);
	}

	public List<Lotto> findAllLottos() {
		return lottoRepository.findAllLottos();
	}

	public void saveWinningResult(WinningResult winningResult) {
		lottoRepository.saveWinningResult(winningResult);
	}

	public void saveRankCounts() {
		lottoRepository.saveStatistics(countRanks());
	}

	private int[] countRanks() {
		int[] rankCounts = new int[MAX_RANK.getValue() + 1];
		List<Lotto> lottos = lottoRepository.findAllLottos();
		WinningResult winningResult = lottoRepository.getWinningResult();
		for (Lotto lotto : lottos) {
			int matchCount = lotto.getMatchCount(winningResult.getWinningNumbers());
			boolean hasBonus = lotto.contains(winningResult.getBonusNumber());
			int rank = Grade.of(matchCount, hasBonus).getRank();
			rankCounts[rank]++;
		}
		return rankCounts;
	}

	public int[] getRankCounts() {
		return lottoRepository.getStatistics();
	}

	public String calculateProfitRate() {
		long price = lottoRepository.getPrice();
		int[] rankCounts = lottoRepository.getStatistics();
		long sumProfit = 0;
		for (int rank = MAX_RANK.getValue(); rank >= MIN_RANK.getValue(); rank--) {
			sumProfit += (Grade.getGradeByRank(rank).getPrize() * rankCounts[rank]);
		}

		double profitRate = (double)sumProfit / price * 100;

		return String.format("%.1f", profitRate);
	}
}
