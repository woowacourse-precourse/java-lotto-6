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
	
	public static void lottoCompare(List<LottoNumber> lottoList) {
		List<LottoNumber> lottoCompare = lottoList;
		int count = 0;
		for (LottoNumber lottoInstance : lottoCompare) {
			List<Integer> computerNumber = lottoInstance.getComputerNumber();
			count = playerNumberCompare(computerNumber);
			if (count == 5 && bonusNumberCompare(computerNumber)) {
				fiveBonusCorrect++;
			}else {
				sumResult(count);
			}
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
		if (computerNumber.contains(Application.playerBonusNumber)) {
			return true;
		}
		return false;
	}
	
	public static void earningRateCaculator() {
		
//		enum Prize {
//			prize1, prize2, prize3, prize4, prize5
//		}
		
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
	
	public static void resultPrint() {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + threeCorrect + "개");
		System.out.println("4개 일치 (50,000원) - " + fourCorrect + "개");
		System.out.println("5개 일치 (1,500,000원) - " + fiveCorrect + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusCorrect + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + sixCorrect + "개");
		System.out.println("총 수익률은 " + sixCorrect + "입니다.");	
	}
}
