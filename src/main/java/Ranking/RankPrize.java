package Ranking;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lottoBuy.LottoPurchase;

public class RankPrize {

	private List<Integer> winningNumbers;
	private List<Lotto> lottos;
	private int bonusNumber;
	private Map<Prize, Integer> prizeCounts;
	double profitPercentage;

	public RankPrize(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
		this.lottos = lottos;
	}

	public void LotteryCale() {
		prizeCounts = calculateMatchCounts();
	}

	public void TotalProfitCal(LottoPurchase purchase) {
		int totalPrizeAmount = calculateToTalPrizeAmout();

		double totalSpent = purchase.getNumber() * purchase.lottoMinAmout();
		profitPercentage = ((totalPrizeAmount - totalSpent) / totalSpent) * 100;

	}
	
	
	public void winningStatisticsOp() {
		for(Prize prize :  Prize.values()) {
			int count = prizeCounts.get(prize);
			
			if(count > 0) {
				System.out.println(prize.getMatchCount() + "개 일치 (" + prize.getprizeAmout()+ "원) -" + count + "개");
			}
			System.out.println("총 수익률은 " + profitPercentage + "% 입니다.");
		}
	}

	public Map<Prize, Integer> calculateMatchCounts() {
		Map<Prize, Integer> prizeCounts = new EnumMap<>(Prize.class);

		for (Prize prize : Prize.values()) {
			prizeCounts.put(prize, 0);
		}

		for (Lotto lotto : lottos) {
			List<Integer> lottoNumbers = lotto.getLottoNumbers();
			long matchedCount = lottoNumbers.stream().filter(winningNumbers::contains).count();
			boolean bonusMatch = lottoNumbers.contains(bonusNumber);

			for (Prize prize : Prize.values()) {
				if (matchedCount == prize.getMatchCount()) {
					if (prize == Prize.FIVE_MATCH_WITH_BONUS && !bonusMatch) {
						continue;
					}
					prizeCounts.put(prize, prizeCounts.get(prize) + 1);
				}
			}
		}

		return prizeCounts;
	}

	private int calculateToTalPrizeAmout() {
		int totalPrizeAmout = 0;
		for (Prize prize : prizeCounts.keySet()) {
			totalPrizeAmout += prizeCounts.get(prize) * prize.getprizeAmout();
		}
		return totalPrizeAmout;
	}
}