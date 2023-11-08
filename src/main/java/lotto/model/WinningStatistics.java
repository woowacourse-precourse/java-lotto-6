package lotto.model;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningStatistics {

	private final int NO_MATCH_NUMBERS = 12;
	private final int PERCENT = 100;
	private final double ROUND_NUMBER = 10.0;
	private final int PLUS_ONE_COUNT = 1;

	private Map<Rank, Integer> winnings;
	private long totalWinningAmount;
	private double totalProfitRate;

	public WinningStatistics() {
		winnings = new LinkedHashMap<>();

		winnings.put(Rank.FIFTH, 0);
		winnings.put(Rank.FOURTH, 0);
		winnings.put(Rank.THIRD, 0);
		winnings.put(Rank.SECOND, 0);
		winnings.put(Rank.FIRST, 0);
		winnings.put(Rank.NOTHING, 0);

		totalWinningAmount = 0;
		totalProfitRate = 0.0;
	}

	public Map<Rank, Integer> getWinnings() {
		return winnings;
	}

	public void addWinning(Lotto purchasedLotto, Lotto winningLotto, BonusNumber bonusNumber) {
		Rank rank = Rank.getRank(matchNumberSize(purchasedLotto.getNumbers(), winningLotto.getNumbers()),
				winBonusNumber(purchasedLotto.getNumbers(), bonusNumber));

		winnings.put(rank, winnings.get(rank) + PLUS_ONE_COUNT);
		totalWinningAmount += rank.getMoney();
	}

	private int matchNumberSize(List<Integer> purchaseLottoNumbers, List<Integer> winningLottoNumbers) {
		Set<Integer> purchaseLottoSet = new HashSet<>(purchaseLottoNumbers);
		purchaseLottoSet.addAll(winningLottoNumbers);

		return NO_MATCH_NUMBERS - purchaseLottoSet.size();
	}

	private boolean winBonusNumber(List<Integer> purchaseLottoNumbers, BonusNumber bonusNumber) {
		return purchaseLottoNumbers.contains(bonusNumber.getNumber());
	}

	public double getTotalProfitRate(int money) {
		totalProfitRate = calculateTotalProfitRate(money);
		return this.totalProfitRate;
	}

	private double calculateTotalProfitRate(int money) {
		double rawProfitRate = (double) totalWinningAmount / money * PERCENT;
		return Math.round(rawProfitRate * ROUND_NUMBER) / ROUND_NUMBER;
	}
}
