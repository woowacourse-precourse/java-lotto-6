package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class UserLotto {

	private Integer price;

	private List<Lotto> allLotto;

	public UserLotto(String price) {
		this.price = Integer.parseInt(price);
		int lottoCount = this.price / 1000;
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			Lotto lotto = new Lotto(numbers);
			this.allLotto.add(lotto);
		}

	}

}
