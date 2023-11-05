package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class Output {
	public static void purchaseLottoNumbers(List<Lotto> purchasedLottoList) {
		System.out.println(purchasedLottoList.size() + "개를 구매했습니다.");
		purchasedLottoList
			.forEach(lotto -> System.out.println(lotto.toString()));
	}

	public static void winningResult() {
		System.out.println("당첨 통계\n"
			+ "---");
		// TODO: 당첨 통계에 대한 출력을 구현한다.
	}

	public static void newLine() {
		System.out.println();
	}
}
