package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
	public List<Lotto> makeLotto(int lottoCount){
		List<Lotto> lottos = new ArrayList<>();
		for(int i = 0; i < lottoCount; i++){
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Lotto lotto = new Lotto(numbers);
			lottos.add(lotto);
		}
		return lottos;
	}
}
