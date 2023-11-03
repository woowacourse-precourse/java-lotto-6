package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoHost {
	static Lotto winningNumberLotto;
	static int bonusNumber;

	LottoHost() {

	}

	LottoHost(Lotto winningNumberLotto, int bonusNumber) {
		this.winningNumberLotto = winningNumberLotto;
		this.bonusNumber = bonusNumber;
	}

	List<Integer> makeRandomLottoNumber() {
		List<Integer> randomNumberList = new ArrayList<>();

		HashSet<Integer> numberCheck = new HashSet();

		while(randomNumberList.size() < 6) {
			int num = Randoms.pickNumberInRange(1, 45);
			if(!numberCheck.contains(num)) {
				randomNumberList.add(num);
				numberCheck.add(num);
			}
		}

		return randomNumberList;
	}
}
