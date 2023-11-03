package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
	final static int LOTTOSTARTNUMBER = 1;
	final static int LOTTOENDNUMBER = 45;
	List<Lotto> lottos;
	
	public Lottos(int n) {
		lottos = generateLottos(n);
	}
	
	private List<Lotto> generateLottos(int n) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		for (int i=0; i<n; i++) {
			Lotto lotto = new Lotto(generateRandomNumbers(Lotto.LOTTOLENGTH));
			lottos.add(lotto);
		}
		return lottos;
	}
	
	private List<Integer> generateRandomNumbers(int n) {
		return Randoms.pickUniqueNumbersInRange(LOTTOSTARTNUMBER, LOTTOENDNUMBER, n);
	}
	
	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}
}