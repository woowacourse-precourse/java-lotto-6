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
		FIRST_PLACE(7,2_000_000_000),
		SECOND_PLACE(6,300_000_000),
		THIRD_PLACE(5,1_500_000),
		FORTH_PLACE(4,50_000),
		FIFHT_PLACE(3,5_000);

		private final int matchCount;
		private final int prizeMoney;

		Prize(int matchCount, int prizeMoney) {
			this.matchCount = matchCount;
			this.prizeMoney = prizeMoney;
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
			numberOfHits++; // 보너스 볼을 맞췄을 경우
		}
		if(numberOfHits == LOTTO_LENGTH){
			numberOfHits++; //1등은 7 return
		}
		return numberOfHits ;
	}

	private void printResult() {
		int totalProfit = 0;
		System.out.println("당첨 통계\n---");
		// 2등을 제외한 나머지 등수에 대한 출력
		for (Prize prize : Prize.values()) {
			if (prize != Prize.SECOND_PLACE) { // 2등을 제외하고 처리
				int prizeCount = (int) lottoResult.stream().filter(prizeMoney -> prizeMoney == prize.getPrizeMoney()).count();
				System.out.println(prize.matchCount + "개 일치 (" + prize.getPrizeMoney() + "원) - " + prizeCount + "개");
				totalProfit += prizeCount * prize.getPrizeMoney();
			}
		}
		// 2등에 해당하는 경우만 특별하게 처리
		int secondPrizeCount = (int) lottoResult.stream().filter(prizeMoney -> prizeMoney == Prize.SECOND_PLACE.getPrizeMoney()).count();
		if (secondPrizeCount > 0) {
			// "5개 일치, 보너스 볼 일치" 로 출력하기 위해 matchCount를 5로 설정
			System.out.println("5개 일치, 보너스 볼 일치 (" + Prize.SECOND_PLACE.getPrizeMoney() + "원) - " + secondPrizeCount + "개");
			totalProfit += secondPrizeCount * Prize.SECOND_PLACE.getPrizeMoney();
		}
		// 수익률 계산 및 출력
		double rateOfProfit = getRateOfProfit(totalProfit);
		System.out.println("총 수익률은 " + rateOfProfit + "%입니다.");
	}
	
	

	private double getRateOfProfit(int profit) {
		double rateOfProfit = 100 * ((double)profit / (lottoShop.getLottos().size() * LOTTO_PRICE));
		BigDecimal roundedRateOfProfit = new BigDecimal(rateOfProfit).setScale(2, RoundingMode.HALF_UP);
		
		return roundedRateOfProfit.doubleValue();
	}


}
