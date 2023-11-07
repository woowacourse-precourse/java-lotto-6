package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;

public class LottosMaker {

	public static List<Lotto> make(int purchaseTime) {

		List<Lotto> lottos = new ArrayList<>();
		RandomNumberCreator randomNumberCreator = new RandomNumberCreator();

		for (int i = 0; i < purchaseTime; i++) {
			List<Integer> randomNumbers = new ArrayList<>(randomNumberCreator.create());
			Lotto lotto = new Lotto(randomNumbers);
			lottos.add(lotto);
		}

		return lottos;
	}

}
