package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class MyLottos {

	private final List<Lotto> lottos;

	public MyLottos(int purchaseCount) {
		this.lottos = purchaseLotto(purchaseCount);
	}

	public void printPurchaseLotto() {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
		}
	}

	private List<Lotto> purchaseLotto(int purchaseCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 1; i <= purchaseCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			lottos.add(new Lotto(numbers));
		}
		return lottos;
	}

}
