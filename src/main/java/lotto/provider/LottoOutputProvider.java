package lotto.provider;

import java.util.List;

import lotto.domain.Lotto;

public class LottoOutputProvider {

	public void getOutputBuyLotto(List<Lotto> lottos) {
		System.out.println();
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.forEach(lotto ->
			System.out.println(lotto.toString()));
		System.out.println();
	}


}
