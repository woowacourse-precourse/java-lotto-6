package lotto.model;

import static lotto.util.Constants.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
	private int budget;
	private List<Lotto> lottoList;

	public UserLotto(int budget) {
		this.budget = budget;
		this.lottoList = new ArrayList<>();
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}

	public int getBudget() {
		return budget;
	}

	public void purchaseLotto(){
		for (int i = 0; i < this.getBudget() / LOTTO_PRICE; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_RANDOM_NUMBER_MIN, LOTTO_RANDOM_NUMBER_MAX, COUNT_OF_LOTTO);
			Lotto purchaseOne = new Lotto(numbers);
			this.lottoList.add(purchaseOne);
		}
	}
}
