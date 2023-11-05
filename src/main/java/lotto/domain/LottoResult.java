package lotto.domain;

public class LottoResult {
	public static void numberCompare() {
		
	}
	
	public static void earningRateCaculator() {
		
	}
	
	public static void resultPrint() {
		int number = 100;
		double percent = 100.0;
		
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + number + "개");
		System.out.println("4개 일치 (50,000원) - " + number + "개");
		System.out.println("5개 일치 (1,500,000원) - " + number + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + number + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + number + "개");
		System.out.println("총 수익률은 " + percent + "입니다.");	
	}
}
