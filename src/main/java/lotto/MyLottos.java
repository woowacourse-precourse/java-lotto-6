package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoRank;

public class MyLottos {
	public static final int LOTTO_PRICE = 1000;
	private static final int percent = 100;

	private final List<Lotto> lottos;
	private final EnumMap<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
	private double profit;

	public MyLottos(int purchaseCount) {
		this.lottos = purchaseLotto(purchaseCount);
		this.profit = 0;
	}

	public void printPurchaseLotto() {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
		}
	}

	private List<Lotto> purchaseLotto(int purchaseCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 1; i <= purchaseCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			lottos.add(new Lotto(numbers));
		}
		return lottos;
	}

	//당첨 통계 출력 메서드 -> set -> rank : 개수
	public void compareLottoNumber(Lotto winnerLotto, BonusNumber bonusNumber) {
		// 집합을 사용해 교집합의 개수를 비교하는 로직
		Set<Integer> winnerNumbers = new HashSet<>(winnerLotto.getNumbers());
		for (Lotto lotto : lottos) {
			Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
			lottoNumbers.retainAll(winnerNumbers);
			recordLottoResult(lottoNumbers.size(), checkBonusNumber(bonusNumber, lotto));
		}
	}

	public void printResults() {
		for (LottoRank rank : LottoRank.values()) {
			int count = results.getOrDefault(rank, 0);
			System.out.println(rank.toString() + " - " + count + "개");
		}
	}

	public void printProfit() {
		System.out.printf("총 수익률은 %.1f%%입니다.", profit * percent);
	}

	public void calculateEarningRate() {
		double totalPrizeMoney = 0;
		for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
			double prizeMoney = entry.getKey().getPrizeMoney();
			int winCount = entry.getValue();
			totalPrizeMoney += prizeMoney * winCount;
		}
		this.profit = totalPrizeMoney / (lottos.size() * LOTTO_PRICE);
	}

	private void recordLottoResult(int matchingCount, boolean isBonusNumberCorrect) {
		LottoRank rank = LottoRank.getRank(matchingCount, isBonusNumberCorrect);
		if (rank == null) {
			return;
		}
		results.put(rank, results.getOrDefault(rank, 0) + 1);
	}

	private boolean checkBonusNumber(BonusNumber bonusNumber, Lotto lotto) {
		return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public EnumMap<LottoRank, Integer> getResults() {
		return this.results;
	}

	public double getProfit() {
		return this.profit;
	}
}
