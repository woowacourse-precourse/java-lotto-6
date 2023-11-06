package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Application;

public class LottoResult {
	public static void numberCompare() {
		List<Integer> resultStorage = new ArrayList<Integer>();
		int cnt = 0;
		int index = 0;
		for(int i = 0; i < Application.computerNumber.size(); i++) {
			boolean t = Application.computerNumber.contains(Application.playerNumber.get(i));
			
			if(t) {
				cnt++;
			}	
		}
		resultStorage.add(index, cnt);
		index++;
		System.out.println("일치하는 숫자는 " + cnt + "개입니다.");
	}
	
	public static void earningRateCaculator() {
		
//		enum Prize {
//			prize1, prize2, prize3, prize4, prize5
//		}
		
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
