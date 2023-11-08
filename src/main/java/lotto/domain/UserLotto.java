package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class UserLotto {

	private Integer price;

	private Integer lottoCount;

	private List<Lotto> allLotto = new ArrayList<>();

	public void setLotto(String price) {
		this.price = Integer.parseInt(price);
		this.lottoCount = this.price / 1000;
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			List<Integer> sortedNumbers = new ArrayList<>(numbers); // 테스트 불변 오류로 새 리스트 생성
			Collections.sort(sortedNumbers);
			Lotto lotto = new Lotto(sortedNumbers);
			this.allLotto.add(lotto);
		}
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getLottoCount() {
		return lottoCount;
	}

	public List<Lotto> getAllLotto() {
		return allLotto;
	}
}
