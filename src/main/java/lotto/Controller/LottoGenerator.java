//LottoGenerator.java
package lotto.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoInfo;
import lotto.Lotto;

public class LottoGenerator {
	public List<Lotto> makeLotto(int lottoCount) {
		Set<Lotto> uniqueLottos = new HashSet<>();

		while (uniqueLottos.size() < lottoCount) {
			List<Integer> numbers = generateRandomNumbers();
			numbers.sort(Integer::compareTo);
			Lotto lotto = new Lotto(numbers);
			uniqueLottos.add(lotto);
		}

		return new ArrayList<>(uniqueLottos);
	}

	private List<Integer> generateRandomNumbers(){
		int minNumber = LottoInfo.getMIN_NUMBER();
		int maxNumber = LottoInfo.getMAX_NUMBER();
		int count = LottoInfo.getNUMBER_COUNT();
		return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);
	}
}
