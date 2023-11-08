package lotto.view;

import java.util.List;

public class OutputView {
	public static void printLottoAmount(int amount){
		System.out.println(amount + "개를 구매했습니다.");
	}

	public static void printLottoNumbers(List<Integer> lottoNumber){
		System.out.println(lottoNumber);
	}

	public static void printPrizeResult(){
		System.out.println("당첨 통계");
		System.out.println("---");
	}

	public static void printPrizeMessage(){
		// TODO 당첨 값을 어떻게 보낼 지 구현 후 수정
	}

	public static void printEarningRate(double rate){
		System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
	}
}
