package lotto.View;

import java.util.List;

import lotto.Lotto;

public class OutputView {
	public static void printPurchasedMessage(int lottoCount, List<Lotto> lottos){
		printLottoCount(lottoCount);
		printLottos(lottos);
	}

	private static void printLottoCount(int lottoCount){
		System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
	}

	private static void printLottos(List<Lotto> lottos){
		for(Lotto lotto : lottos){
			System.out.println(lotto.toString());
		}
	}

	public static void printResult(List<Integer> prices){}
}
