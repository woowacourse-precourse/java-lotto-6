package lotto;

import java.util.List;

public class OutputView {

	void showAmount(int amount) {
		System.out.println(amount + "개를 구매했습니다.");
	}

	void showBuyLottoNumber(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	void printResult(List<Integer> resultList) {
		System.out.println("3개 일치 (5,000원) - " + resultList.get(0) + "개");
		System.out.println("4개 일치 (50,000원) - " + resultList.get(1) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + resultList.get(2) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultList.get(3) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + resultList.get(4) + "개");
	}

	void printRate(double rate) {
		System.out.println(String.format("총 수익률은 %.1f%%입니다.", rate));
	}
}
