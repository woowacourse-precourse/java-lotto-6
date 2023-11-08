package domain;

import static org.mockito.ArgumentMatchers.intThat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
	
	public void PrintResult() {
		System.out.println("당첨 결과");
	}
	
	public void PrintLine() {
		System.out.println("---");
	}

	public void winningStatisticsOp() {
	    PrintResult();
	    PrintLine();

	    int totalPrizeAmount = calculateToTalPrizeAmout();

	    DecimalFormat df = new DecimalFormat("#,###");

	    for (Prize prize : Prize.values()) {
	        int count = prizeCounts.get(prize);
	        String prizeDescription = prize.getMatchCount() + "개 일치 (" + df.format(prize.getprizeAmout()) + "원)";
	        String resultLine = String.format("%s - %d개", prizeDescription, count);
	        System.out.println(resultLine);
	    }

	    if (profitPercentage >= 0) {
	        DecimalFormat percentageDf = new DecimalFormat("#.0");
	        System.out.println("총 수익률은 " + percentageDf.format(profitPercentage) + "% 입니다.");
	    } else {
	        System.out.println("총 수익률은 0.0% 입니다.");
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