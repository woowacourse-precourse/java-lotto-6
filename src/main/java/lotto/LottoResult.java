package lotto;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class LottoResult {
	private static final int LOTTO_LENGTH = 6;
	private static final int LOTTO_PRICE = 1000;

	private final LottoShop lottoShop;
	private List<Integer> lottoResult = new ArrayList<>();

	public LottoResult(LottoShop lottoShop) {
		this.lottoShop = lottoShop;
	}

	public enum Prize{
		FIFHT_PLACE(3,5_000,"3개 일치 (5,000원) - "),
		FOURTH_PLACE(4,50_000,"4개 일치 (50,000원) - "),
		THIRD_PLACE(5,1_500_000,"5개 일치 (1,500,000원) - "),
		SECOND_PLACE(7,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
		FIRST_PLACE(6,2_000_000_000,"6개 일치 (2,000,000,000원) - ");

		private final int matchCount;
		private final int prizeMoney;
		private final String resultText;

		Prize(int matchCount, int prizeMoney, String resultText) {
			this.matchCount = matchCount;
			this.prizeMoney = prizeMoney;
			this.resultText = resultText;
		}
		public int getPrizeMoney() {
			return prizeMoney;
		}
		public static int getPrizeByMatchCount(int matches) {
			for (Prize prize: Prize.values()) {
				if (prize.matchCount == matches) {
					return prize.getPrizeMoney();
				}
			}
			return 0;
		}
	}
	
	public void getResult() {
	    ArrayList<Lotto> lottos = lottoShop.getLottos();
	    for(Lotto lotto : lottos) {
	        int matches = verifyLotto(lotto.getNumbers());
	        int prizeMoney = Prize.getPrizeByMatchCount(matches);
	        this.lottoResult.add(prizeMoney);
	    }
	}

	private int verifyLotto(List<Integer> lotto){
		List<Integer> winningNumbers = lottoShop.getWinningNumbers();
		int bonusNumber = lottoShop.getBonusNumber();
		int numberOfHits = 0;
		for (int number: lotto) {
			if(winningNumbers.contains(number)){
				numberOfHits++;
			}
		}
		if (numberOfHits == LOTTO_LENGTH - 1 && lotto.contains(bonusNumber)) {
			numberOfHits += 2; // 보너스 볼을 맞췄을 경우 7 return
		}
		return numberOfHits ;
	}

	public void printResult() {
		int totalProfit = 0;
		System.out.println("당첨 통계\n---");
		for (Prize prize : Prize.values()) {
			int prizeCount = (int) lottoResult.stream().filter(prizeMoney -> prizeMoney == prize.getPrizeMoney()).count();
			System.out.println(prize.resultText + prizeCount + "개");
			totalProfit += prizeCount * prize.getPrizeMoney();
		}
		// 수익률 계산 및 출력
		System.out.println("총 수익률은 " + getRateOfProfit(totalProfit) + "%입니다.");
	}
	private double getRateOfProfit(int profit) {
		double rateOfProfit = 100 * ((double)profit / (lottoShop.getLottos().size() * LOTTO_PRICE));
		BigDecimal roundedRateOfProfit = new BigDecimal(rateOfProfit).setScale(2, RoundingMode.HALF_UP);
		
		return roundedRateOfProfit.doubleValue();
	}
}
