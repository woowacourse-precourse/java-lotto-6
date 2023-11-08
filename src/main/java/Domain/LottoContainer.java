package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoContainer {
	int MyLottoCount = 0;
	List<List<Integer>> MyLottos = new ArrayList<List<Integer>>();
	Lotto Lotto;

	public LottoContainer(Integer _MyLottoCount) {
		MyLottoCount = _MyLottoCount;
	}

	public void makeMyLotto() {
		for (int i = 0; i < MyLottoCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Lotto = new Lotto(numbers);
			MyLottos.add(Lotto.get_LottoNum());
		}
	}

	public void outputMyLotto() {
		for (int i = 0; i < MyLottoCount; i++) {			
			System.out.println(MyLottos.get(i));
		}
		System.out.println("");
	}

	public List<List<Integer>> get_MyLottos() {
		return MyLottos;
	}
}
