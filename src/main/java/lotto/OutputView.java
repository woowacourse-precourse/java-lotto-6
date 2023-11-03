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
}
