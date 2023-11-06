package lotto.domain;

import java.util.List;

import lotto.Application;
import lotto.object.LottoNumber;

public class LottoResult {
	private static int threeCorrect = 0;
	private static int fourCorrect = 0;
	private static int fiveCorrect = 0;
	private static int fiveBonusCorrect = 0;
	private static int sixCorrect = 0;
	private static double earningRate;
	
	public static void lottoCompare(List<LottoNumber> lottoList) {
		List<LottoNumber> lottoCompare = lottoList;
		int count = 0;
		for (LottoNumber lottoInstance : lottoCompare) {
			List<Integer> computerNumber = lottoInstance.getComputerNumber();
			count = playerNumberCompare(computerNumber);
			if (count == 5 && bonusNumberCompare(computerNumber)) {
				fiveBonusCorrect++;
				return;
			}
			sumResult(count);
		}
	}
		
	public static int playerNumberCompare(List<Integer> computerNumber) {
		int count = 0;
		for (int i = 0; i < Application.playerNumber.size(); i ++) {
			
			boolean t = computerNumber.contains(Application.playerNumber.get(i));
		
			if(t) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean bonusNumberCompare(List<Integer> computerNumber) {
		if (computerNumber.contains(Application.bonusNumber)) {
			return true;
		}
		return false;
	}
	
	public static void earningRateCaculator() {
		Double purchaseAmount = Double.valueOf(Application.purchaseAmount);
		double earning = (5000 * threeCorrect) + (50000 * fourCorrect) + (1500000 * fiveCorrect) + (30000000 * fiveBonusCorrect) + (2000000000 * sixCorrect); 
		earningRate = earning / purchaseAmount * 100;
	}
	
	public static void sumResult(int count) {
		if (count == 3) {
			threeCorrect++;
		}
		if (count == 4) {
			fourCorrect++;
		}
		if (count == 5) {
			fiveCorrect++;
		}
		if (count == 6) {
			sixCorrect++;
		}	
	}
	
	public static void resultContents() {		
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + threeCorrect + "개");
		System.out.println("4개 일치 (50,000원) - " + fourCorrect + "개");
		System.out.println("5개 일치 (1,500,000원) - " + fiveCorrect + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusCorrect + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + sixCorrect + "개");
		System.out.println("총 수익률은 " + String.format("%.1f",earningRate) + "%입니다.");	
	}
}
