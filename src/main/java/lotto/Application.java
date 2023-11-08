package lotto;

import java.util.List;

import lotto.io.Input;

public class Application {
	public static void main(String[] args) {
		System.out.println("구매 금액을 입력해주세요.");
		final var amount = Input.readPurchaseAmount();
		final var lottoSeller = new LottoSeller();
		final var lottos = lottoSeller.sellLotto(amount);
		System.out.println(lottos.size() + "개를 구매했습니다.");
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}

	}
}
