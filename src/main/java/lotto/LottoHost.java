package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoHost {

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
