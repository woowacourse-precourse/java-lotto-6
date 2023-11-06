package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class User {
	private Integer money;
	private List<Lotto> lottoList = new ArrayList<>();

	public User(Integer money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
		}
		this.money = money;
		setLottoList();
	}

	private void setLottoList() {
		Integer lottoCount = money / 1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.WINNING_NUMBER_LENGTH));
			System.out.println(lotto);
			lottoList.add(lotto);
		}
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}

	public Integer getMoney() {
		return this.money;
	}
}
