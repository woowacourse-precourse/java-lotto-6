package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static lotto.system.Constant.LOTTO_LENGTH;
import static lotto.system.Constant.LOTTO_START_NUMBER;
import static lotto.system.Constant.LOTTO_END_NUMBER;

public class Lottos {
	final List<Lotto> lottos;
	
	public Lottos(int n) {
		lottos = generateLottos(n);
	}
	
	private List<Lotto> generateLottos(int n) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		for (int i=0; i<n; i++) {
			Lotto lotto = new Lotto(generateRandomNumbers(LOTTO_LENGTH.getconstant()));
			lottos.add(lotto);
		}
		return lottos;
	}
	
	private List<Integer> generateRandomNumbers(int n) {
		return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getconstant(), LOTTO_END_NUMBER.getconstant(), LOTTO_LENGTH.getconstant());
	}
	
	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}
}