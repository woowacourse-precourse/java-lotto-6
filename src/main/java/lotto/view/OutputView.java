package lotto.view;

import java.util.List;

import lotto.model.Lotto;

public class OutputView {
	public static void informationBuyMessage() {
		System.out.println("구입금액을 입력해 주세요.");
	}
	public static void informationPlayersByLottosCount(List<Lotto> playersLotto) {
		int playerLottosSize = playersLotto.size();
		System.out.println(playerLottosSize+"개를 구매했습니다.");
	}
}
